package co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.repositorios;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades.DocenteEntity;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer>{

    @Query(value = """
    SELECT CASE WHEN COUNT(f.id) > 0 THEN 0 ELSE 1 END
    FROM persona d
    JOIN curso_docente cd ON cd.docente_id = d.id
    JOIN curso c ON c.id = cd.curso_id
    JOIN franja_horaria f ON f.curso_id = c.id
    WHERE d.id = :idDocente
      AND f.dia = :#{#dia.name()}
      AND (f.hora_inicio < :horaFin AND f.hora_fin > :horaInicio)
    """, nativeQuery = true)
    Integer estaDisponibleRaw(@Param("idDocente") Integer idDocente,
                        @Param("dia") EnumDias dia,
                        @Param("horaInicio") LocalTime horaInicio,
                        @Param("horaFin") LocalTime horaFin);
    
    default boolean estaDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        return estaDisponibleRaw(idDocente, dia, horaInicio, horaFin) == 1;
    }

    //TODO: Verificar si funciona correctamente
    @Query("""
    SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END
    FROM DocenteEntity d
    WHERE d.correo = :correo
    """)
    boolean existePorCorreo(String correo);
}
