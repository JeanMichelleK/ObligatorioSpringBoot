package bios.obligatorio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bios.obligatorio.dominio.entidades.Paquete;
import bios.obligatorio.excepciones.ExcepcionNoExiste;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.excepciones.ExcepcionYaExiste;
import bios.obligatorio.repositorios.IRepositorioPaquetes;
import bios.obligatorio.repositorios.especificaciones.EspecificacionesPaquetes;

@Service
public class ServicioPaquetes implements IServicioPaquetes{
    
    @Autowired
    private IRepositorioPaquetes repositorioPaquetes;

    @Override
    public List<Paquete> listar(String criterio){
        return repositorioPaquetes.findAll(EspecificacionesPaquetes.buscarYFiltrar(criterio));
    }

    @Override
    public Paquete obtener(Long id){
        return repositorioPaquetes.findById(id).orElse(null);
    }

    @Override
    public void agregar(Paquete paquete) throws ExcepcionObligatorio{
        Paquete paqueteExistente = repositorioPaquetes.findById(paquete.getId()).orElse(null);
        if (paqueteExistente != null){
            throw new ExcepcionYaExiste("El paquete ya existe.");
        }
        repositorioPaquetes.save(paquete);
    }

    @Override
    public void modificar(Paquete paquete) throws ExcepcionObligatorio{
        Paquete paqueteExistente = repositorioPaquetes.findById(paquete.getId()).orElse(null);
        if (paqueteExistente == null){
            throw new ExcepcionNoExiste("El paquete no existe.");
        }
        repositorioPaquetes.save(paquete);
    }

    @Override
    public void eliminar(Long id) throws ExcepcionObligatorio{
        Paquete paqueteExistente = repositorioPaquetes.findById(id).orElse(null);
        if (paqueteExistente == null){
            throw new ExcepcionNoExiste("El paquete no existe.");
        }
        repositorioPaquetes.deleteById(id);
    }
}
