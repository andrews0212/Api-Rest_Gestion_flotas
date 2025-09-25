package entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "mantenimientos")
public class Mantenimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula")
    private Vehiculos matricula;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehiculos getMatricula() {
        return matricula;
    }

    public void setMatricula(Vehiculos matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

}