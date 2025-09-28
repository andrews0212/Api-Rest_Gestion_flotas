package org.example.apiflotas.service;

import org.example.apiflotas.entidad.Conductores;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.apiflotas.repositorios.ConductoresRepositorio;

@RestController
@RequestMapping("/conductores")
public class ServiceConductor {
    private final ConductoresRepositorio conductorRepositorio;

    public ServiceConductor(ConductoresRepositorio conductorRepositorio) {
        this.conductorRepositorio = conductorRepositorio;
    }

    @GetMapping
    public java.util.List<Conductores> getAllConductores() {
        return conductorRepositorio.findAll();
    }

    @GetMapping("/{dni}")
    public Conductores findConductor(@PathVariable String dni) {
        return conductorRepositorio.findById(dni).orElse(null);
    }

    @PostMapping
    public Conductores addConductor(@RequestBody Conductores conductor) {
        return conductorRepositorio.save(conductor);
    }

    @PutMapping("/{dni}")
    public org.springframework.http.ResponseEntity<Conductores> updateConductor(@PathVariable String dni, @RequestBody Conductores conductor) {
        return conductorRepositorio.findById(dni).map(existingConductor -> {
            existingConductor.setNombre(conductor.getNombre());
            existingConductor.setLicencia(conductor.getLicencia());
            existingConductor.setTelefono(conductor.getTelefono());
            existingConductor.setEmail(conductor.getEmail());
            existingConductor.setDireccion(conductor.getDireccion());
            existingConductor.setFechaContratacion(conductor.getFechaContratacion());
            existingConductor.setFechaNacimiento(conductor.getFechaNacimiento());
            return ResponseEntity.ok(conductorRepositorio.save(existingConductor));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{dni}")
    public org.springframework.http.ResponseEntity<Void> deleteConductor(@PathVariable String dni) {
        if (conductorRepositorio.existsById(dni)) {
            conductorRepositorio.deleteById(dni);
            return ResponseEntity.noContent().build();
        }
        return org.springframework.http.ResponseEntity.notFound().build();
    }

}
