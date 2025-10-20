package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;

public interface CadenaResponsabilidadIntPort {
    boolean estaEspacioFisicoDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);
    boolean estaDocenteDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);
    EspacioFisico obtenerEspacioFisicoById(Integer idEspacio);
    
}