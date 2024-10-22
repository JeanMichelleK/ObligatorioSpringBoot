package bios.obligatorio.dominio.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
