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

import bios.obligatorio.dominio.entidades.Paquete;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.servicios.IServicioCategorias;
import bios.obligatorio.servicios.IServicioPaquetes;
import javax.validation.Valid;

@Controller
@RequestMapping("/paquetes")
public class ControladorPaquetes {
    
    @Autowired
    private IServicioCategorias servicioCategorias;

    @Autowired
    private IServicioPaquetes servicioPaquetes;

    @GetMapping
    public String mostrarIndex(@RequestParam(required = false) String criterio, Model model){
        List<Paquete> paquetes = servicioPaquetes.listar(criterio);
        model.addAttribute("paquetes",paquetes);
        return "paquetes/index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(@ModelAttribute Paquete paquete, Model model){
        model.addAttribute("categorias", servicioCategorias.listarT());
        return "paquetes/agregar";
    }

    @PostMapping("/agregar")
    public String procesarAgregar(@ModelAttribute @Valid Paquete paquete, BindingResult result, Model model,RedirectAttributes attributes){
        model.addAttribute("categorias", servicioCategorias.listarT());
        if (result.hasErrors()){
            return "paquetes/agregar";
        }
        try {
            servicioPaquetes.agregar(paquete);
            attributes.addFlashAttribute("mensaje","Paquete agregado con exito.");
            return "redirect:/paquetes";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje", "Error!" + e.getMessage());
            return "paquetes/agregar";
        }
    }

    @GetMapping("/{id}")
    public String mostrarDetalle(@PathVariable("id") Long id, Model model){
        Paquete paquete = servicioPaquetes.obtener(id);
        if (paquete != null){
            model.addAttribute("paquete", paquete);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro el paquete con la id: " + id);
        }
        return "paquetes/detalle";
    }

    @GetMapping("/modificar")
    public String mostrarModificar(Long id, Model model){
        model.addAttribute("categorias", servicioCategorias.listarT());
        Paquete paquete = servicioPaquetes.obtener(id);
        if(paquete != null){
            model.addAttribute("paquete", paquete);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro el paquete con la id: " + id);
        }
        return "paquetes/modificar";
    }

    @PostMapping("/modificar")
    public String procesarMoficiar(@ModelAttribute @Valid Paquete paquete,BindingResult result, Model model, RedirectAttributes attributes ){
        model.addAttribute("categorias", servicioCategorias.listarT());
        if (result.hasErrors()){
            return "paquetes/modificar";
        }
        try {
            servicioPaquetes.modificar(paquete);
            attributes.addFlashAttribute("mensaje","Paquete modificado con exito.");
            return "redirect:/paquetes";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje", "Error!" + e.getMessage());
            return "paquetes/modificar";
        }
    }

    @GetMapping("/eliminar")
    public String mostrarEliminar(Long id, Model model){
        Paquete paquete = servicioPaquetes.obtener(id);
        if(paquete != null){
            model.addAttribute("paquete", paquete);
        } else {
            model.addAttribute("mensaje","Error! No se encontro el paquete con la id: " + id);
        }
        return "productos/eliminar";
    }

    @PostMapping("/eliminar")
    public String procesarEliminar(Long id, Model model, RedirectAttributes attributes){
        try {
            servicioPaquetes.eliminar(id);
            attributes.addFlashAttribute("mensaje","Paquete eliminado con exito.");
            return "redirect:/paquetes";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error!" + e.getMessage());
            return "paquetes/eliminar";
        }
    }
}
