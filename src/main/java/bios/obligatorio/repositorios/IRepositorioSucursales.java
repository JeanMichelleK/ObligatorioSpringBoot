package bios.obligatorio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import bios.obligatorio.dominio.entidades.Sucursal;

public interface IRepositorioSucursales extends JpaRepository<Sucursal, Long>, JpaSpecificationExecutor<Sucursal>{
    
}
