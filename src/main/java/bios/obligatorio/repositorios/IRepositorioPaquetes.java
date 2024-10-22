package bios.obligatorio.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import bios.obligatorio.dominio.entidades.EstadoRastreo;
import bios.obligatorio.dominio.entidades.Paquete;

public interface IRepositorioPaquetes extends JpaRepository<Paquete,Long>, JpaSpecificationExecutor<Paquete> {
    
    @Override
    @EntityGraph(type = EntityGraphType.LOAD, attributePaths = { "categorias", "estadorastreos", "clientes"})
    List<Paquete> findAll();

    @Override
    @EntityGraph(type = EntityGraphType.LOAD, attributePaths = { "categorias", "estadorastreos", "clientes"})
    Optional<Paquete> findById(Long id);
    
    boolean existsByEstadoRastreo(EstadoRastreo estadoRastreo);
}
