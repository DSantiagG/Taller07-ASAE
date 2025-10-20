package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;

public interface GestionarCursoCUIntPort {
    List<Curso> findByAsignaturaNombre(String nombreAsignatura);

    Curso obtenerCursoById(Integer idCurso);
}