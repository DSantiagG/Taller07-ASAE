package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;

public interface GestionarCursoCUIntPort {
    List<CursoEntity> findByAsignaturaNombre(String nombreAsignatura);

    CursoEntity obtenerCursoById(Integer idCurso);
}