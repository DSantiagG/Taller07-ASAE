package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaPersistIntPort {
    FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria);
    List<FranjaHoraria> encontrarByCursoId(Integer cursoId);
    List<FranjaHoraria> encontrarByDocenteId(Integer docenteId);
    void eliminarFranjasPorCurso(Integer cursoId);
    List<FranjaHoraria> listarFranjas();
}
