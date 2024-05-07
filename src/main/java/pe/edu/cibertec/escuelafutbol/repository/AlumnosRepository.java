package pe.edu.cibertec.escuelafutbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumnos;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumnos, Integer> {

}
