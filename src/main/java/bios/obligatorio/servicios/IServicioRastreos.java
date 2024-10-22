package bios.obligatorio.servicios;

import java.util.List;

import bios.obligatorio.dominio.entidades.EstadoRastreo;
import bios.obligatorio.excepciones.ExcepcionObligatorio;

public interface IServicioRastreos {
    
    List<EstadoRastreo> listar(String criterio);
    EstadoRastreo obtener(Long id);
    void agregar(EstadoRastreo estadoRastreo) throws ExcepcionObligatorio;
    void modificar(EstadoRastreo estadoRastreo) throws ExcepcionObligatorio;
    void eliminar(Long id) throws ExcepcionObligatorio;
    
}
