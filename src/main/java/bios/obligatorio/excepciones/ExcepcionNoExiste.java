package bios.obligatorio.excepciones;

public class ExcepcionNoExiste extends ExcepcionObligatorio{
    public ExcepcionNoExiste(){

    }

    public ExcepcionNoExiste(String mensaje){
        super(mensaje);
    }

    public ExcepcionNoExiste(String mensaje, Exception excepcionInterna){
        super(mensaje, excepcionInterna);
    }
}
