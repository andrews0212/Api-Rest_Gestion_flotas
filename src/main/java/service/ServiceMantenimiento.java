package service;

import entidad.Mantenimientos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositorios.MantenimientoRepositorio;
import java.util.List;

@RestController
@RequestMapping("/mantenimientos")
public class ServiceMantenimiento {

    private final MantenimientoRepositorio mantenimientoRepositorio;

    // this is controller
    public ServiceMantenimiento(MantenimientoRepositorio mantenimientoRepositorio) {
        this.mantenimientoRepositorio = mantenimientoRepositorio;
    }

    //get,post,put,delete
    @GetMapping()
    public List<Mantenimientos> getAllProducts() {
        return mantenimientoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Mantenimientos FindMantenimiento(@PathVariable String id) {
        return mantenimientoRepositorio.findById(id).get();
    }

    @PostMapping
    public Mantenimientos addMantenimiento(@RequestBody Mantenimientos mantenimiento) {
        return mantenimientoRepositorio.save(mantenimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantenimientos> updateMantenimiento(@PathVariable String id, @RequestBody Mantenimientos mantenimiento) {

        return mantenimientoRepositorio.findById(id).map(exist -> {
            exist.setCosto(mantenimiento.getCosto());
            exist.setDescripcion(mantenimiento.getDescripcion());
            exist.setFecha(mantenimiento.getFecha());
            exist.setMatricula(mantenimiento.getMatricula());
            return ResponseEntity.ok(mantenimientoRepositorio.save(exist));
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        if (mantenimientoRepositorio.existsById(id)) {
            mantenimientoRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
