package bios.obligatorio.dominio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "paquetes")
public class Paquete {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime fechaHoraRegistro;
    @NotBlank
    @Column(nullable = false)
    @Size(max = 25)
    private String nombreDestinatario;
    @NotBlank
    @Column(nullable = false)
    @Size(max = 35)
    private String direccionDestinatario;
    @NotBlank
    @Column(nullable = false)
    @Size(max = 9, min = 9)
    private String telefonoDestinatario;
    @Column(nullable = false)
    private boolean cobrarAlDestinatario;
    @NotNull
    @ManyToOne
    private EstadoRastreo estadoRastreo;
    @NotNull
    @ManyToOne(optional = false)
    private Cliente cliente;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    public Long getId() {
        return id;
    }
    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }
    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }
    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }
    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }
    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }
    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }
    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }
    public boolean isCobrarAlDestinatario() {
        return cobrarAlDestinatario;
    }
    public void setCobrarAlDestinatario(boolean cobrarAlDestinatario) {
        this.cobrarAlDestinatario = cobrarAlDestinatario;
    }
    public EstadoRastreo getEstadoRastreo() {
        return estadoRastreo;
    }
    public void setEstadoRastreo(EstadoRastreo estadoRastreo) {
        this.estadoRastreo = estadoRastreo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Paquete() {
    }
    public Paquete(LocalDateTime fechaHoraRegistro, String nombreDestinatario, String direccionDestinatario,
            String telefonoDestinatario, boolean cobrarAlDestinatario, EstadoRastreo estadoRastreo, Cliente cliente,
            Categoria categoria) {
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.nombreDestinatario = nombreDestinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.cobrarAlDestinatario = cobrarAlDestinatario;
        this.estadoRastreo = estadoRastreo;
        this.cliente = cliente;
        this.categoria = categoria;
    }


}
