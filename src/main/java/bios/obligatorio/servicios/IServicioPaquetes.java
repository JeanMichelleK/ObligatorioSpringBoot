package bios.obligatorio.servicios;

import java.util.List;

import bios.obligatorio.dominio.entidades.Paquete;
import bios.obligatorio.excepciones.ExcepcionObligatorio;

public interface IServicioPaquetes {
    List<Paquete> listar(String criterio);
    Paquete obtener(Long id);
    void agregar(Paquete paquete) throws ExcepcionObligatorio;
    void modificar(Paquete paquete) throws ExcepcionObligatorio;
    void eliminar(Long id) throws ExcepcionObligatorio;
    
}
