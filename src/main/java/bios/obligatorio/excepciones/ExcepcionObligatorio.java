package bios.obligatorio.excepciones;

public class ExcepcionObligatorio extends Exception{
    
    
    public ExcepcionObligatorio(){

    }

    public ExcepcionObligatorio(String mensaje){
        super(mensaje);
    }

    public ExcepcionObligatorio(String mensaje, Exception excepcionInterna){
        super(mensaje, excepcionInterna);
    }
}
