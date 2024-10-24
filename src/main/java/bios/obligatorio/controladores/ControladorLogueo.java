package bios;


@Controller
public class ControladorLogueo {

    @GetMapping("/login")
    public String ingresar(Principal principal) {
        if (principal == null || principal instanceof AnonymousAuthenticationToken) {
            return "ingresar";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String salir() {
        return "salir";
    }

}