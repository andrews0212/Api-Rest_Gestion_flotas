package org.example.apiflotas.service;

import org.example.apiflotas.entidad.Asignaciones;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.apiflotas.repositorios.AsignacionesRepositorios;

@RestController
@RequestMapping("/asignaciones")
public class ServiceAsignaciones {
    private final AsignacionesRepositorios asignacionesRepositorio;

    public ServiceAsignaciones(AsignacionesRepositorios asignacionesRepositorio) {
        this.asignacionesRepositorio = asignacionesRepositorio;
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<Asignaciones> getAllAsignaciones() {
        return asignacionesRepositorio.findAll();
    }

    @org.springframework.web.bind.annotation.GetMapping("/{id}")
    public Asignaciones findAsignacion(@PathVariable String id) {
        return asignacionesRepositorio.findById(id).orElse(null);
    }

    @org.springframework.web.bind.annotation.PostMapping
    public Asignaciones addAsignacion(@RequestBody Asignaciones asignacion) {
        return asignacionesRepositorio.save(asignacion);
    }

    @org.springframework.web.bind.annotation.PutMapping("/{id}")
    public ResponseEntity<Asignaciones> updateAsignacion(@PathVariable String id, @RequestBody Asignaciones asignacion) {
        return asignacionesRepositorio.findById(id).map(existingAsignacion -> {
            existingAsignacion.setMatricula(asignacion.getMatricula());
            existingAsignacion.setIdRuta(asignacion.getIdRuta());
            existingAsignacion.setFechaAsignacion(asignacion.getFechaAsignacion());
            return org.springframework.http.ResponseEntity.ok(asignacionesRepositorio.save(existingAsignacion));
        }).orElse(org.springframework.http.ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignacion(@PathVariable String id) {
        if (asignacionesRepositorio.existsById(id)) {
            asignacionesRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return org.springframework.http.ResponseEntity.notFound().build();
        }
    }
}
