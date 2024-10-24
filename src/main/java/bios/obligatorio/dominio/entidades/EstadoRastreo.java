package bios.obligatorio.dominio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "estadorastreos")
public class EstadoRastreo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, length = 40)
    private String descripcion;
    
    private boolean activo;
    
    public Long getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo(){
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public EstadoRastreo(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
