package org.example.apiflotas.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rutas")
public class Rutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "origen", nullable = false, length = 100)
    private String origen;

    @Size(max = 100)
    @NotNull
    @Column(name = "destino", nullable = false, length = 100)
    private String destino;

    @Column(name = "distancia_km", precision = 10, scale = 2)
    private BigDecimal distanciaKm;

    @Column(name = "duracion_horas", precision = 10, scale = 2)
    private BigDecimal duracionHoras;

    @Column(name = "fechaHoraInicio")
    private Instant fechaHoraInicio;

    @Column(name = "fechaHoraFin")
    private Instant fechaHoraFin;

    @OneToMany(mappedBy = "idRuta")
    private Set<Asignaciones> asignaciones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BigDecimal getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(BigDecimal distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public BigDecimal getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(BigDecimal duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public Instant getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Instant fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Instant getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Instant fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Set<Asignaciones> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Set<Asignaciones> asignaciones) {
        this.asignaciones = asignaciones;
    }

}