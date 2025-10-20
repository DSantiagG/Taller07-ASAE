package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

public interface EspacioFisicoRepository extends CrudRepository<EspacioFisicoEntity, Integer>{

    List<EspacioFisicoEntity> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(String nombre, Integer capacidad);

    @Query("""
    SELECT CASE WHEN COUNT(f) > 0 THEN false ELSE true END
    FROM EspacioFisicoEntity e
    JOIN e.franjasHorarias f
    WHERE e.id = :idEspacio
      AND f.dia = :dia
      AND (f.horaInicio < :horaFin AND f.horaFin > :horaInicio)
    """)
    boolean estaDisponible(@Param("idEspacio") Integer idEspacio,
                        @Param("dia") EnumDias dia,
                        @Param("horaInicio") LocalTime horaInicio,
                        @Param("horaFin") LocalTime horaFin);

    @Modifying
    @Query("UPDATE EspacioFisicoEntity e SET e.estado = :nuevoEstado WHERE e.id = :idEspacio")
    int actualizarEstado(@Param("idEspacio") Integer idEspacio, @Param("nuevoEstado") Boolean nuevoEstado);

}
