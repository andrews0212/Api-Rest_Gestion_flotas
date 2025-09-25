package repositorios;

import entidad.Mantenimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepositorio extends JpaRepository<Mantenimientos, String> {
}
