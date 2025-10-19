package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;

@Service
public class GestionEspacioFisicoPersistAdapter implements GestionarEspacioFisicoPersistIntPort{

    @Override
    public boolean estaDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaDisponible'");
    }

    @Override
    public List<EspacioFisico> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombreAndCapacidadGreaterThanEqual'");
    }

    @Override
    public List<EspacioFisico> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int actualizarEstado(Integer idEspacio, Boolean nuevoEstado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarEstado'");
    }

    @Override
    public Boolean existsById(Integer idEspacio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
    
}
