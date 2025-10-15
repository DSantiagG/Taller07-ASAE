package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Integer>{

    List<CursoEntity> findByObjAsignaturaNombre(String nombreAsignatura);

    @Query("""
    SELECT c
    FROM CursoEntity c
    WHERE c.id = :idCurso
    """)
    CursoEntity obtenerCursoConFranjasYEspacio(@Param("idCurso") Integer idCurso);

}
