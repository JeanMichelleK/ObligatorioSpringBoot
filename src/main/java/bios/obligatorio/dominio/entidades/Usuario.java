package bios.obligatorio.dominio.entidades;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
