package repositorios;

import entidad.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepositorio extends JpaRepository<Vehiculos, String> {
}
