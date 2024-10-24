package bios.obligatorio.repositorios.especificaciones;

import org.springframework.data.jpa.domain.Specification;

import bios.obligatorio.dominio.entidades.EstadoRastreo;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EspecificacionesRastreos {

    public static Specification<EstadoRastreo> textoCodigoIgualA(String textoCodigo){
        if(textoCodigo == null) return null;
        Long id;
        try {
            id = Long.parseLong(textoCodigo);
        } catch (NumberFormatException e) {
            return null;
        }
         return new Specification<EstadoRastreo>() {
            @Override
            public Predicate toPredicate(Root<EstadoRastreo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.equal(root.get("id"), id);
            }
        };
    }

     public static Specification<EstadoRastreo> descripcionContiene(String descripcion){
        if (descripcion == null) return null;

        return new Specification<EstadoRastreo>(){
            @Override
            public Predicate toPredicate(Root<EstadoRastreo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.like(root.get("descripcion"), "%" + descripcion + "%"); 
            }
        };
    }

    public static Specification<EstadoRastreo> soloActivos(){
        return new Specification<EstadoRastreo>() {
        @Override
        public Predicate toPredicate(Root<EstadoRastreo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.isTrue(root.get("activo")); 
            }   
        };
    }

     public static Specification<EstadoRastreo> buscar(String criterio) {
        if (criterio == null || criterio.isBlank()) return null;

        return Specification.where(textoCodigoIgualA(criterio)).or(descripcionContiene(criterio)).and(soloActivos());
    }
}
