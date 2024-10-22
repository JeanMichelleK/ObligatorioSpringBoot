package bios.obligatorio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import bios.obligatorio.dominio.entidades.Categoria;
import bios.obligatorio.excepciones.ExcepcionNoExiste;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.excepciones.ExcepcionTieneVinculos;
import bios.obligatorio.excepciones.ExcepcionYaExiste;
import bios.obligatorio.repositorios.IRepositorioCategorias;
import bios.obligatorio.repositorios.especificaciones.EscpecificacionesCategorias;

@Service
public class ServicioCategorias implements IServicioCategorias{
    
    @Autowired
    private IRepositorioCategorias repositorioCategorias;

    @Override
    public List<Categoria> listar(String Criterio){
        return repositorioCategorias.findAll(EscpecificacionesCategorias.buscar(Criterio));
    }
    @Override
    public List<Categoria> listarT(){
        return repositorioCategorias.findAll();
    }

    @Override
    public Categoria obtener(Long id){
        return repositorioCategorias.findById(id).orElse(null);
    }

   @Override
   public void agregar(Categoria categoria) throws ExcepcionObligatorio{
    Categoria categoriaExistente = repositorioCategorias.findById(categoria.getId()).orElse(null);
    if (categoriaExistente != null){
        throw new ExcepcionYaExiste("Esa categoria ya existe.");
    }
    repositorioCategorias.save(categoria);
   }

   @Override
   public void modificar(Categoria categoria) throws ExcepcionObligatorio{
    Categoria categoriaExistente = repositorioCategorias.findById(categoria.getId()).orElse(null);
    if (categoriaExistente == null){
        throw new ExcepcionNoExiste("Esa categoria no existe.");
    }
    repositorioCategorias.save(categoria);
   }

   @Override
   public void eliminar(Long id) throws ExcepcionObligatorio{
    Categoria categoriaExistente = repositorioCategorias.findById(id).orElse(null);
    if (categoriaExistente == null){
        throw new ExcepcionNoExiste("Esa categoria no existe.");
    }
    try {
        repositorioCategorias.deleteById(id);
    } catch (DataIntegrityViolationException e) {
        throw new ExcepcionTieneVinculos("La categoria tiene paquetes vinculados.");
    }
   }
}
