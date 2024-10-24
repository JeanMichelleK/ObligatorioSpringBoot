package bios.obligatorio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bios.obligatorio.dominio.entidades.EstadoRastreo;
import bios.obligatorio.dominio.entidades.Paquete;
import bios.obligatorio.excepciones.ExcepcionNoExiste;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.excepciones.ExcepcionYaExiste;
import bios.obligatorio.repositorios.IRepositorioEstadoRastreos;
import bios.obligatorio.repositorios.IRepositorioPaquetes;
import bios.obligatorio.repositorios.especificaciones.EspecificacionesRastreos;

@Service
public class SerivcioRastreos implements IServicioRastreos {
    @Autowired
    private IRepositorioEstadoRastreos repositorioEstadoRastreos;

    @Autowired
    private IRepositorioPaquetes repositorioPaquetes;

    @Override
    public List<EstadoRastreo> listar(String criterio){
        return repositorioEstadoRastreos.findAll(EspecificacionesRastreos.buscar(criterio));
    }

    @Override
    public EstadoRastreo obtener(Long id){
        return repositorioEstadoRastreos.findById(id).orElse(null);
    }

    @Override
    public void agregar(EstadoRastreo estadoRastreo) throws ExcepcionObligatorio {
        EstadoRastreo estadoRastreoExistente = repositorioEstadoRastreos.findById(estadoRastreo.getId()).orElse(null);
        if (estadoRastreoExistente != null){
            throw new ExcepcionYaExiste("Ese rastreo ya existe.");
        }
        repositorioEstadoRastreos.save(estadoRastreo);
    }

    @Override 
    public void modificar(EstadoRastreo estadoRastreo) throws ExcepcionObligatorio{
        estadoRastreo.setActivo(true);
        EstadoRastreo estadoRastreoExistente = repositorioEstadoRastreos.findById(estadoRastreo.getId()).orElse(null);
        if (estadoRastreoExistente == null){
            throw new ExcepcionYaExiste("Ese rastreo no existe.");
        }
        repositorioEstadoRastreos.save(estadoRastreo);
    }

    @Override
    public void eliminar(Long id) throws ExcepcionObligatorio{
        EstadoRastreo estadoRastreo = repositorioEstadoRastreos.findById(id).orElse(null);
        if(estadoRastreo == null){
            throw new ExcepcionNoExiste("Ese rastreo no existe.");
        }
       List<Paquete> paquetes = repositorioPaquetes.findByEstadoRastreo_Id(id);
        if(paquetes.size() == 0){
            repositorioEstadoRastreos.deleteById(id);
        } else {
            estadoRastreo.setActivo(false);
            repositorioEstadoRastreos.save(estadoRastreo);
        }
    }
}
