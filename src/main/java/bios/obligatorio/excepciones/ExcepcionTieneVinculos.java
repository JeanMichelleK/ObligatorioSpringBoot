package bios.obligatorio.excepciones;

public class ExcepcionTieneVinculos  extends ExcepcionObligatorio{
    
    public ExcepcionTieneVinculos(){

    }

    public ExcepcionTieneVinculos(String mensaje){
        super(mensaje);
    }

    public ExcepcionTieneVinculos(String mensaje, Exception excepcionInterna){
        super(mensaje, excepcionInterna);
    }
}
