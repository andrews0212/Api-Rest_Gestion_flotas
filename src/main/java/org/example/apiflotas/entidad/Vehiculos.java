package org.example.apiflotas.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "vehiculos")
public class Vehiculos {
    @Id
    @Size(max = 50)
    @Column(name = "matricula", nullable = false, length = 50)
    private String matricula;

    @Size(max = 50)
    @NotNull
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Size(max = 50)
    @NotNull
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @NotNull
    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Size(max = 50)
    @NotNull
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Size(max = 20)
    @NotNull
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @OneToMany(mappedBy = "matricula")
    private Set<Asignaciones> asignaciones = new LinkedHashSet<>();

    @OneToMany(mappedBy = "matricula")
    private Set<Mantenimientos> mantenimientos = new LinkedHashSet<>();

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Asignaciones> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Set<Asignaciones> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public Set<Mantenimientos> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(Set<Mantenimientos> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

}