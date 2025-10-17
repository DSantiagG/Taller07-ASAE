package co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;

public interface GestionarEspacioFisicoCUIntPort {
    List<EspacioFisicoEntity> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad);

    List<EspacioFisicoEntity> findAll ();
    
    int actualizarEstado(Integer idEspacio, Boolean nuevoEstado);
}