package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.ValidacionHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort {

    private final ValidacionHandler cadenaValidaciones;

    public GestionarFranjaHorariaCUAdapter(ValidacionHandler cadenaValidaciones) {
        this.cadenaValidaciones = cadenaValidaciones;
    }

    @Override
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria) {
        this.cadenaValidaciones.validar(franjaHoraria);
        throw new UnsupportedOperationException("Unimplemented method 'crearFranjaHoraria'");
    }

    @Override
    public List<FranjaHorariaEntity> findByDocenteId(Integer docenteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDocenteId'");
    }

    @Override
    public List<FranjaHorariaEntity> findByCursoId(Integer cursoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCursoId'");
    }

    @Override
    public List<FranjaHorariaEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void eliminarFranjasPorCurso(Integer idCurso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarFranjasPorCurso'");
    }
    
}
