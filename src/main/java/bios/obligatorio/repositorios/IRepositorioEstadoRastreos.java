package bios.obligatorio.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import bios.obligatorio.dominio.entidades.EstadoRastreo;

public interface IRepositorioEstadoRastreos extends JpaRepository<EstadoRastreo,Long>, JpaSpecificationExecutor<EstadoRastreo> {
}
