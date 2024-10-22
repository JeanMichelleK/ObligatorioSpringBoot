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

import bios.obligatorio.dominio.entidades.EstadoRastreo;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.servicios.IServicioRastreos;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/rastreos")
public class ControladorEstadoRastreos {

    @Autowired
    private IServicioRastreos servicioRastreos;
    
    @GetMapping
    public String mostrarIndex(@RequestParam(required = false) String criterio, Model model){
        List<EstadoRastreo> rastreos = servicioRastreos.listar(criterio);
        model.addAttribute("rastreos", rastreos);
        return "rastreos/index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(@ModelAttribute EstadoRastreo estadoRastreo){
        return "rastreos/agregar";
    }

    @PostMapping("/agregar")
    public String procesarAgregar(@ModelAttribute @Valid EstadoRastreo estadoRastreo, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "rastreos/agregar";
        }
        try {
            servicioRastreos.agregar(estadoRastreo);
            attributes.addFlashAttribute("mensaje","Rastreo agregado con exito.");
            return "redirect:/rastreos";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje", "Error! " + e.getMessage());
            return "rastreos/agregar";
        }
    }

    @GetMapping("/{id}")
    public String mostrarDetalles(@PathVariable("id") Long id, Model model){
        EstadoRastreo estadoRastreo = servicioRastreos.obtener(id);
        if(estadoRastreo != null){
            model.addAttribute("rastreo", estadoRastreo);
        } else {
            model.addAttribute("mensaje","Error! No hay un rastreo con la id: " + id);
        }
        return "sucursal/detalle";
    }

    @GetMapping("/modificar")
    public String mostrarModificar(Long id, Model model){
        EstadoRastreo estadoRastreo = servicioRastreos.obtener(id);
        if (estadoRastreo != null){
            model.addAttribute("rastreo", estadoRastreo);
        } else {
            model.addAttribute("mensaje","Error! No se encontro el rastreo con la id: " + id);
        }
        return "rastreos/modificar";
    }

    @PostMapping("/modificar")
    public String procesarModificar(@ModelAttribute @Valid EstadoRastreo estadoRastreo, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "rastreos/modificar";
        }
        try {
            servicioRastreos.modificar(estadoRastreo);
            attributes.addFlashAttribute("mensaje", "Rastreo modificado con exito.");
            return "redirect:/rastreos";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error! " + e.getMessage());
            return "rastreos/modificar";
        }
    }

    @GetMapping("/eliminar")
    public String mostrarEliminar(Long id, Model model){
        EstadoRastreo estadoRastreo = servicioRastreos.obtener(id);
        if(estadoRastreo != null){
            model.addAttribute("rastreo", estadoRastreo);
        } else {
            model.addAttribute("mensaje","Error! No se encontro el rastreo con la id: " + id);
        }
        return "rastreos/eliminar";
    }

    @PostMapping("/eliminar")
    public String procesarEliminar(Long id, Model model, RedirectAttributes attributes){
        try {
            servicioRastreos.eliminar(id);
            attributes.addFlashAttribute("mensaje","Rastreo eliminado con exito.");
            return "redirect:/rastreos";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error!" + e.getMessage());
            return "rastreos/eliminar";
        }
    }
}
