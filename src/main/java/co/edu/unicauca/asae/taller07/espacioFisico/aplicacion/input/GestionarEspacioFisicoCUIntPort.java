package co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;



public interface GestionarEspacioFisicoCUIntPort {
    List<EspacioFisico> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad);

    List<EspacioFisico> findAll ();
    
    int actualizarEstado(Integer idEspacio, Boolean nuevoEstado);
}