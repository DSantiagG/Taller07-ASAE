package co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public interface GestionarFranjaHorariaCUIntPort {

    FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria);

    List<FranjaHorariaEntity> findByDocenteId(Integer docenteId);

    List<FranjaHorariaEntity> findByCursoId(Integer cursoId);

    List<FranjaHorariaEntity> findAll();

    void eliminarFranjasPorCurso(Integer idCurso);
}