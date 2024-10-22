package bios.obligatorio.excepciones;

public class ExcepcionYaExiste  extends ExcepcionObligatorio{
    public ExcepcionYaExiste(){

    }

    public ExcepcionYaExiste(String mensaje){
        super(mensaje);
    }

    public ExcepcionYaExiste(String mensaje, Exception excepcionInterna){
        super(mensaje, excepcionInterna);
    }
}
