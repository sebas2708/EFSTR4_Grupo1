package pe.edu.cibertec.escuelafutbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.escuelafutbol.model.bd.Pruebas_fisicas;

@Repository
public interface PruebasRepository extends JpaRepository<Pruebas_fisicas, Integer> {
}
