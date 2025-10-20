package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public interface GestionarFranjaHorariaCUIntPort {

    FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria, Integer idCurso, Integer idEspacioFisico);

    List<FranjaHoraria> findByDocenteId(Integer docenteId);

    List<FranjaHoraria> findByCursoId(Integer cursoId);

    List<FranjaHoraria> findAll();

    void eliminarFranjasPorCurso(Integer idCurso);
}