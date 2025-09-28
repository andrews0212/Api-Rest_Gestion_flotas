package org.example.apiflotas.service;

import org.example.apiflotas.entidad.Vehiculos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.apiflotas.repositorios.VehiculoRepositorio;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class ServiceVehiculo {

    public final VehiculoRepositorio vehiculoRepositorio;


    public ServiceVehiculo(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    @GetMapping
    public List<Vehiculos> getAllProducts() {
        return vehiculoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Vehiculos FindVehiculo(@PathVariable String id) {
        return vehiculoRepositorio.findById(id).get();
    }

    @PostMapping
    public Vehiculos addVehiculo(@RequestBody Vehiculos vehiculo){
        return vehiculoRepositorio.save(vehiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculos> actualizarVehiculo(@PathVariable String id, @RequestBody Vehiculos vehiculo){
        return vehiculoRepositorio.findById(id).map(exist -> {
            exist.setAnio(vehiculo.getAnio());
            exist.setEstado(vehiculo.getEstado());
            exist.setMarca(vehiculo.getMarca());
            exist.setModelo(vehiculo.getModelo());
            exist.setTipo(vehiculo.getTipo());
            return ResponseEntity.ok(vehiculoRepositorio.save(exist));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        if (vehiculoRepositorio.existsById(id)) {
            vehiculoRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
