package org.example.apiflotas.repositorios;

import org.example.apiflotas.entidad.Mantenimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoRepositorio extends JpaRepository<Mantenimientos, String> {
}
