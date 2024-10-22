package bios.obligatorio.servicios;

import java.util.List;

import bios.obligatorio.dominio.entidades.Sucursal;
import bios.obligatorio.excepciones.ExcepcionObligatorio;

public interface IServicioSucursales {
    List<Sucursal> listar(String criterio);
    Sucursal obtener(Long id);
    void agregar(Sucursal sucursal) throws ExcepcionObligatorio;
    void modificar(Sucursal sucursal) throws ExcepcionObligatorio;
    void eliminar(Long id) throws ExcepcionObligatorio;
}
