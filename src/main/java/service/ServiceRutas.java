package service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositorios.RutasRepositorios;

@RestController
@RequestMapping("/rutas")
public class ServiceRutas {

    private final RutasRepositorios rutasRepositorio;

    public ServiceRutas(RutasRepositorios rutasRepositorio) {
        this.rutasRepositorio = rutasRepositorio;
    }

    @GetMapping
    public java.util.List<entidad.Rutas> getAllRutas() {
        return rutasRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public entidad.Rutas findRuta(@PathVariable String id) {
        return rutasRepositorio.findById(id).orElse(null);
    }

    @PostMapping
    public entidad.Rutas addRuta(@RequestBody entidad.Rutas ruta) {
        return rutasRepositorio.save(ruta);
    }

    @PutMapping("/{id}")
    public org.springframework.http.ResponseEntity<entidad.Rutas> updateRuta(@PathVariable String id, @RequestBody entidad.Rutas ruta) {
        return rutasRepositorio.findById(id).map(existingRuta -> {
            existingRuta.setOrigen(ruta.getOrigen());
            existingRuta.setDestino(ruta.getDestino());
            existingRuta.setDistanciaKm(ruta.getDistanciaKm());
            existingRuta.setDuracionHoras(ruta.getDuracionHoras());
            existingRuta.setFechaHoraInicio(ruta.getFechaHoraInicio());
            existingRuta.setFechaHoraFin(ruta.getFechaHoraFin());
            return org.springframework.http.ResponseEntity.ok(rutasRepositorio.save(existingRuta));
        }).orElse(org.springframework.http.ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable String id) {
        if (rutasRepositorio.existsById(id)) {
            rutasRepositorio.deleteById(id);
            return org.springframework.http.ResponseEntity.noContent().build();
        }
        return org.springframework.http.ResponseEntity.notFound().build();
    }

}
