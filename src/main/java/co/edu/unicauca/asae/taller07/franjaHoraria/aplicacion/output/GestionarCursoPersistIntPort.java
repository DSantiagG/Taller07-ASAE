package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;

public interface GestionarCursoPersistIntPort {
    List<Curso> findByAsignaturaNombre(String nombreAsignatura);
    Curso obtenerCursoById(Integer idCurso);
    boolean existsById(Integer idCurso);
}
