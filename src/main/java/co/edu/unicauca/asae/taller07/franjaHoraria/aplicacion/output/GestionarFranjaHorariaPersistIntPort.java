package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaPersistIntPort {
    FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria);
    List<FranjaHoraria> findByCursoId(Integer cursoId);
}
