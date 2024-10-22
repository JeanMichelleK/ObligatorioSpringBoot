package bios.obligatorio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bios.obligatorio.dominio.entidades.Categoria;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.servicios.IServicioCategorias;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorias")
public class ControladorCategorias {
    
    @Autowired
    private IServicioCategorias servicioCategorias;

    @GetMapping
    public String mostrarIndex(@RequestParam(required = false) String criterio, Model model){
        List<Categoria> categorias = servicioCategorias.listar(criterio);
        model.addAttribute("categorias", categorias);
        return "categorias/index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(@ModelAttribute Categoria categoria, Model model){
        return "categorias/agregar";
    }

    @PostMapping("/agregar")
    public String procesarAgregar(@ModelAttribute @Valid Categoria categoria, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "categorias/agregar";
        }
        try {
            servicioCategorias.agregar(categoria);
            attributes.addFlashAttribute("mensaje","Categoria agregada con exito.");
            return "redirect:/categorias";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error!" + e.getMessage());
            return "categorias/agregar";
        }
    }

    @GetMapping("/{id}")
    public String mostrarDetalle(@PathVariable("id") Long id, Model model){
        Categoria categoria = servicioCategorias.obtener(id);
        if (categoria != null){
            model.addAttribute("categoria", categoria);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro la categoria con el ID: " + id);
        }
        return "categorias/detalle";
    }

    @GetMapping("/modificar")
    public String mostrarModificar(Long id , Model model){
        Categoria categoria = servicioCategorias.obtener(id);
        if(categoria != null){
            model.addAttribute("categoria", categoria);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro la categoria con el ID: " + id);
        }
        return "categorias/modificar";
    }

    @PostMapping("/modificar")
    public String procesarModificar(@ModelAttribute @Valid Categoria categoria, BindingResult result, String nombre , Model model, RedirectAttributes attributes ){
        if (result.hasErrors()){
            return "categorias/modificar";
        }
        try {
            servicioCategorias.modificar(categoria);
            attributes.addFlashAttribute("mensaje", "Categoria modificada con exito.");
            return "redirect:/categorias";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error! " + e.getMessage());
            return "productos/modificar";
        }
    }

    @GetMapping("/eliminar")
    public String mostrarEliminar(Long id, Model model){
        Categoria categoria = servicioCategorias.obtener(id);
        if(categoria != null){
            model.addAttribute("categoria", categoria);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro la categoria con el ID: " + id);
        }
        return "categorias/eliminar";
    }

    @PostMapping("/eliminar")
    public String procesarEliminar(Long id, Model model, RedirectAttributes attributes){
        try {
            servicioCategorias.eliminar(id);
            attributes.addFlashAttribute("mensaje","Categoria eliminada con exito.");
            return "redirect:/categorias";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error! " + e.getMessage());
            return "categorias/eliminar";
        }
    }
}
