package bios.obligatorio.dominio.entidades;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @Size(max = 25)
    @NotBlank
    @Column(length = 25)
    private String nombreUsuario;

    @NotBlank
    @Size(max = 16)
    @Column(length = 16, nullable = false)
    private String claveAcceso;

    @NotBlank
    @Size(max = 30)
    @Column(length = 30, nullable = false)
    private String correoElectronico;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "usuario_nombre_usuario") }, inverseJoinColumns = {@JoinColumn(name = "rol_nombre_rol")})
    private Set<Rol> roles;

    private boolean activo;

    public boolean isActivo(){
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String claveAcceso, String correoElectronico, boolean activo) {
        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
        this.correoElectronico = correoElectronico;
        this.activo = activo;

        roles = new HashSet<>();
    }


    
    
}
