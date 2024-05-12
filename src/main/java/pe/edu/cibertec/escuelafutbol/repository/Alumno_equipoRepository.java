package pe.edu.cibertec.escuelafutbol.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumno_equipo;

import java.util.List;

@Repository
public interface Alumno_equipoRepository extends JpaRepository<Alumno_equipo, Integer> {

    @Query(value = "CALL obtener_alumnosxequipo(:id_equipo)",
            nativeQuery = true)
    List<Alumno_equipo> obtenerAlumnosEquipo(@Param("id_equipo") int id_equipo);

    @Modifying
    @Query(value = "CALL actualizar_equipo_estado(:id_alumno)",
            nativeQuery = true)
     void actualizarEquipoEstado(@Param("id_alumno") int id_alumno);
}
