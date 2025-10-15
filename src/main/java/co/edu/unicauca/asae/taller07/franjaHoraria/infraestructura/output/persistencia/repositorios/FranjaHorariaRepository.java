package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

@Repository
public interface FranjaHorariaRepository extends JpaRepository<FranjaHorariaEntity, Integer> {

    List<FranjaHorariaEntity> findByObjCursoId(Integer cursoId);

    @Modifying
    @Query("DELETE FROM FranjaHorariaEntity f WHERE f.objCurso.id = :idCurso")
    void eliminarFranjasPorCurso(@Param("idCurso") Integer idCurso);
}
