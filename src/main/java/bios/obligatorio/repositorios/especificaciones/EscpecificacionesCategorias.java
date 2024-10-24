package bios.obligatorio.repositorios.especificaciones;

import org.springframework.data.jpa.domain.Specification;

import bios.obligatorio.dominio.entidades.Categoria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EscpecificacionesCategorias {
    public static Specification<Categoria> textoCodigoIgualA(String textoCodigo){
        if(textoCodigo == null) return null;
        Long id;
        try {
            id = Long.parseLong(textoCodigo);
        } catch (NumberFormatException e) {
            return null;
        }

        return new Specification<Categoria>() {
            @Override
            public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.equal(root.get("id"), id);
            }
        };
    }

    public static Specification<Categoria> nombreContiene(String nombre){
        if (nombre == null) return null;

        return new Specification<Categoria>(){
            @Override
            public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%"); 
            }
        };
    }
    public static Specification<Categoria> buscar(String criterio) {
        if (criterio == null || criterio.isBlank()) return null;

        return Specification.where(textoCodigoIgualA(criterio)).or(nombreContiene(criterio));
    }
}
