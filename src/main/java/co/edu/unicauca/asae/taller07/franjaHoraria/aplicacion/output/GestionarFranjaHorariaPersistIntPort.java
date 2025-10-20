package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaPersistIntPort {
    FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria);
    Curso findCursoById(Integer idCurso);
    EspacioFisico findEspacioFisicoById(Integer idEspacioFisico);
    List<FranjaHoraria> findByCursoId(Integer cursoId);
}
