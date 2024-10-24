package bios.obligatorio.repositorios.especificaciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.data.jpa.domain.Specification;

import bios.obligatorio.dominio.entidades.Paquete;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EspecificacionesPaquetes {
    public static Specification<Paquete> textoNumeroIgualA(String textoCodigo){
       if(textoCodigo == null) return null;
        Long id;
        try {
            id = Long.parseLong(textoCodigo);
        } catch (NumberFormatException e) {
            return null;
        }

        return new Specification<Paquete>() {
            @Override
            public Predicate toPredicate(Root<Paquete> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                return criteriaBuilder.equal(root.get("id"), id);
            }
        };
    }

    public static Specification<Paquete> textoFechaIgualA(String textoFecha) {
        if (textoFecha == null) return null;

        LocalDate fecha;
        String fechaISO;

        try {
            fecha = LocalDate.parse(textoFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            fechaISO = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            return null;
        }

        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fechaHoraRegistro").as(String.class), "%" + fechaISO + "%");
    }

     public static Specification<Paquete> cedulaUsuarioClienteContiene(String cedula) {
        if (cedula == null) return null;

        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.join("cliente", JoinType.LEFT).get("cedula"), "%" + cedula + "%");
    }

    public static Specification<Paquete> buscarYFiltrar(String criterio){
        Specification<Paquete> especification = Specification.where(null);
        if(criterio != null && !criterio.isBlank()){
            especification = especification.and(textoNumeroIgualA(criterio)).or(textoFechaIgualA(criterio));
        }
        return especification;
    }

}
