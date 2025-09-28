package org.example.apiflotas.entidad;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asignaciones")
public class Asignaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula")
    private Vehiculos matricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ruta")
    private Rutas idRuta;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;

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

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

}