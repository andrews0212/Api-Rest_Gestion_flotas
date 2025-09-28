package org.example.apiflotas.repositorios;

import org.example.apiflotas.entidad.Conductores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductoresRepositorio extends JpaRepository<Conductores, String> {
}
