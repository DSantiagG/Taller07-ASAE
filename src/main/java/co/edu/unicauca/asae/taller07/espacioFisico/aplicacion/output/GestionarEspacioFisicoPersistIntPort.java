package co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;

public interface GestionarEspacioFisicoPersistIntPort {
    boolean estaDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);
}
