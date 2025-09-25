package repositorios;

import entidad.Conductores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductoresRepositorio extends JpaRepository<Conductores, String> {
}
