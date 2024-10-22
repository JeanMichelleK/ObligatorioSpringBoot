package bios.obligatorio.repositorios.especificaciones;

import org.springframework.data.jpa.domain.Specification;

import bios.obligatorio.dominio.entidades.Sucursal;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EspecificacionesSucursal {
    public static Specification<Sucursal> textoCodigoIgualA(String textoCodigo){
        if(textoCodigo == null) return null;
        Long id;
        try {
            id = Long.parseLong(textoCodigo);
        } catch (NumberFormatException e) {
            return null;
        }

        return new Specification<Sucursal>() {
            @Override
            public Predicate toPredicate(Root<Sucursal> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.equal(root.get("id"), id);
            }
        };
    }

    public static Specification<Sucursal> nombreContiene(String nombre){
        if (nombre == null) return null;

        return new Specification<Sucursal>(){
            @Override
            public Predicate toPredicate(Root<Sucursal> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%"); 
            }
        };
    }
    public static Specification<Sucursal> buscar(String criterio) {
        if (criterio == null || criterio.isBlank()) return null;

        return Specification.where(textoCodigoIgualA(criterio)).or(nombreContiene(criterio));
    }
}
