package bios.obligatorio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import bios.obligatorio.dominio.entidades.Sucursal;
import bios.obligatorio.excepciones.ExcepcionNoExiste;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.excepciones.ExcepcionTieneVinculos;
import bios.obligatorio.excepciones.ExcepcionYaExiste;
import bios.obligatorio.repositorios.IRepositorioSucursales;
import bios.obligatorio.repositorios.especificaciones.EspecificacionesSucursal;

@Service
public class ServicioSucursales implements IServicioSucursales{
    
    @Autowired
    private IRepositorioSucursales repositorioSucursales;

    @Override
    public List<Sucursal> listar(String criterio){
        return repositorioSucursales.findAll(EspecificacionesSucursal.buscar(criterio));
    }

    @Override
    public Sucursal obtener(Long id){
        return repositorioSucursales.findById(id).orElse(null);
    }
    
    @Override
    public void agregar(Sucursal sucursal) throws ExcepcionObligatorio{
        Sucursal sucursalExistente = repositorioSucursales.findById(sucursal.getId()).orElse(null);
        if (sucursalExistente != null){
            throw new ExcepcionYaExiste("Esa surucal ya existe.");
        }
        repositorioSucursales.save(sucursal);
    }

    @Override
    public void modificar(Sucursal sucursal) throws ExcepcionObligatorio{
        Sucursal sucursalExistente = repositorioSucursales.findById(sucursal.getId()).orElse(null);
        if (sucursalExistente == null){
            throw new ExcepcionNoExiste("Esa sucursal no existe.");
        }
        repositorioSucursales.save(sucursal);
    }

    @Override
    public void eliminar(Long id) throws ExcepcionObligatorio{
        Sucursal sucursalExistente = repositorioSucursales.findById(id).orElse(null);
        if (sucursalExistente == null){
            throw new ExcepcionNoExiste("Esa sucursal no existe.");
        }
        try {
            repositorioSucursales.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ExcepcionTieneVinculos("La sucursal tiene empleados.");
        }
    }
}
