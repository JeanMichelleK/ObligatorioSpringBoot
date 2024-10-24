package bios.obligatorio.dominio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @Min(1)
    private Long id;

    @NotBlank
    @Size(max = 25)
    @Column(nullable = false, length = 25)
    private String nombre;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sucursal() {
        //this(null,null);
     }

    public Sucursal(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    

}
