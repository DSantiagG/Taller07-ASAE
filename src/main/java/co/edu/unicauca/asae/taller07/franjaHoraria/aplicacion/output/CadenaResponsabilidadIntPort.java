package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;

public interface CadenaResponsabilidadIntPort {
    boolean estaEspacioFisicoDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);
    boolean estaDocenteDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);
    EspacioFisico obtenerEspacioFisicoById(Integer idEspacio);
    Docente obtenerDocenteById(Integer idDocente);
    Curso obtenerCursoById(Integer idCurso);
    
}