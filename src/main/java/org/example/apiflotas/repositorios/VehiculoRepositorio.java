package org.example.apiflotas.repositorios;

import org.example.apiflotas.entidad.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepositorio extends JpaRepository<Vehiculos, String> {
}
