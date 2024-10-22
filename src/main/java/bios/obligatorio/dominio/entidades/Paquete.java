package bios.obligatorio.dominio.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
    @Size(max = 25)
    private String direccionDestinatario;
    @NotBlank
    @Column(nullable = false)
    @Size(max = 9, min = 9)
    private String telefonoDestinatario;
    @Column(nullable = false)
    private boolean cobrarAlDestinatario;
    @ManyToOne
    @JoinColumn(name = "estado_rastreo_id", nullable = false)
    private EstadoRastreo estadoRastreo;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
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
