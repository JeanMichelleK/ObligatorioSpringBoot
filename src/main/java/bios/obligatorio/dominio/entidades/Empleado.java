package bios.obligatorio.dominio.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empleados")
public class Empleado extends Usuario {
    
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Empleado(){

    }

    public Empleado(String nombreUsuario, String claveAcceso, String correoElectronico, boolean activo, Sucursal sucursal) {
        super(nombreUsuario, claveAcceso, correoElectronico, activo);
        this.sucursal = sucursal;
    }
    
}
