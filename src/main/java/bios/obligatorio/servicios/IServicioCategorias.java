package bios.obligatorio.servicios;

import java.util.List;

import bios.obligatorio.dominio.entidades.Categoria;
import bios.obligatorio.excepciones.ExcepcionObligatorio;

public interface IServicioCategorias {
    List<Categoria> listar(String criterio);
    List<Categoria> listarT();
    Categoria obtener(Long id);
    void agregar(Categoria categoria) throws ExcepcionObligatorio;
    void modificar(Categoria categoria) throws ExcepcionObligatorio;
    void eliminar(Long id) throws ExcepcionObligatorio;
}
