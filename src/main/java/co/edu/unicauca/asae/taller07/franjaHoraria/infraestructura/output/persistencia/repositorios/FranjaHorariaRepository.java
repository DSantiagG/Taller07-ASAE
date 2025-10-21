package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

@Repository
public interface FranjaHorariaRepository extends JpaRepository<FranjaHorariaEntity, Integer> { 

    
    List<FranjaHorariaEntity> findByObjCursoId(@Param("idCurso") Integer cursoId);

    @Query("SELECT DISTINCT f FROM FranjaHorariaEntity f " +
           "JOIN FETCH f.objCurso c " +
           "JOIN FETCH f.objEspacioFisico ef " +
           "JOIN c.docentes d " +
           "WHERE d.id = :idDocente")
    List<FranjaHorariaEntity> findByObjDocenteId(@Param("idDocente") Integer docenteId);

    @Modifying
    @Transactional
    @Query("DELETE FROM FranjaHorariaEntity f WHERE f.objCurso.id = :idCurso")
    void eliminarFranjasPorCurso(@Param("idCurso") Integer idCurso);
}
