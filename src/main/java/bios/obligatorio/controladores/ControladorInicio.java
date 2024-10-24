package bios.obligatorio.controladores;

@Controller
@RequestMapping("/")
public class ControladorInicio {

    @GetMapping
    public String mostrarInicio(@RequestParam(required = false) Long codigoCategoria, Model model) {
        
        //Falta definir que va a pasar en la página de inicio
        
    }
