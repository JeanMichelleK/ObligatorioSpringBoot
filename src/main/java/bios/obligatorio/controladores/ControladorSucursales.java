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

import bios.obligatorio.dominio.entidades.Sucursal;
import bios.obligatorio.excepciones.ExcepcionObligatorio;
import bios.obligatorio.servicios.IServicioSucursales;
import javax.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class ControladorSucursales {

    @Autowired
    private IServicioSucursales servicioSucursales;
    
    @GetMapping
    public String mostrarIndex(@RequestParam(required = false) String criterio, Model model){
        List<Sucursal> sucursales = servicioSucursales.listar(criterio);
        model.addAttribute("sucursales",sucursales);
        return "sucursales/index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(@ModelAttribute Sucursal sucursal){
        return "sucursales/agregar";
    }

    @PostMapping("/agregar")
    public String procesarAgregar(@ModelAttribute @Valid Sucursal sucursal, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "sucursales/agregar";
        }
        try {
            servicioSucursales.agregar(sucursal);
            attributes.addFlashAttribute("mensaje","Sucursal agregada con exito.");
            return "redirect:/sucursales";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error!"+ e.getMessage());
            return "sucursales/agregar";
        }
    }

    @GetMapping("/{id}")
    public String mostrarDetalle(@PathVariable("id") Long id, Model model){
        Sucursal sucursal = servicioSucursales.obtener(id);
        if(sucursal != null){
            model.addAttribute("sucursal", sucursal);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro una sucursal con la id " + id + ".");
        }
        return "sucursales/detalle";
    }


    @GetMapping("/modificar")
    public String mostrarModificar(Long id, Model model){
        Sucursal sucursal = servicioSucursales.obtener(id);
        if(sucursal != null){
            model.addAttribute("sucursal", sucursal);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro una sucursal con la id " + id + ".");
        }
        return "sucursales/modificar";
    }

    @PostMapping("/modificar")
    public String procesarModificar(@ModelAttribute @Valid Sucursal sucursal, BindingResult result, String nombre, Model model, RedirectAttributes attributes){
        if (result.hasErrors()){
           return "sucursales/modificar";
        }
        try {
            servicioSucursales.modificar(sucursal);
            attributes.addFlashAttribute("mensaje","Sucursal modificada con exito.");
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje", "Error! " + e.getMessage());
            return "sucursales/modificar";
        }
        return "redirect:/sucursales";
    }
    
    @GetMapping("/eliminar")
    public String mostrarEliminar(Long id, Model model){
        Sucursal sucursal = servicioSucursales.obtener(id);
        if (sucursal != null){
            model.addAttribute("sucursal", sucursal);
        } else {
            model.addAttribute("mensaje", "Error! No se encontro la sucursal con la id:" + id + ".");
        }
        return "sucursales/eliminar";
    }

    @PostMapping("/eliminar")
    public String procesarEliminar(Long id, Model model, RedirectAttributes attributes){
        try {
            servicioSucursales.eliminar(id);
            attributes.addFlashAttribute("mensaje","Sucursal eliminada con exito.");
            return "redirect:/sucursales";
        } catch (ExcepcionObligatorio e) {
            model.addAttribute("mensaje","Error! " + e.getMessage());
            return "empleados/eliminar";
        }
    }


}
