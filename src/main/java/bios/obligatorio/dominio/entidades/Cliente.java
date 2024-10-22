package bios.obligatorio.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario{
    @NotBlank
    @Column(nullable = false , length = 8)
    @Size(max = 8)
    private String cedula;
    @NotBlank
    @Column(nullable = false, length = 30)
    @Size(max= 30)
    private String direccion;
    @NotBlank
    @Column(nullable = false, length = 9)
    @Size(max = 9, min = 9)
    private String telefono;

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente(){

    }
    public Cliente(String nombreUsuario, String claveAcceso, String correoElectronico, boolean activo ,String cedula, String direccion, String telefono) {
        super(nombreUsuario, claveAcceso, correoElectronico, activo);
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
}
