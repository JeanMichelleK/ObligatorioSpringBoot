package bios.obligatorio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import bios.obligatorio.dominio.entidades.Categoria;

public interface IRepositorioCategorias extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {
    
}
