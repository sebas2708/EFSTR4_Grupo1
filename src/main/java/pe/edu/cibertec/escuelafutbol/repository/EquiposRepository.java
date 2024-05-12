package pe.edu.cibertec.escuelafutbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;

import java.util.Optional;

@Repository
public interface EquiposRepository extends JpaRepository<Equipos, Integer> {
}
