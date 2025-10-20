package co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;

public interface GestionarEspacioFisicoPersistIntPort {
    boolean estaDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);

    List<EspacioFisico> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad);

    List<EspacioFisico> findAll ();
    
    int actualizarEstado(Integer idEspacio, Boolean nuevoEstado);

    Boolean existsById(Integer idEspacio);
}