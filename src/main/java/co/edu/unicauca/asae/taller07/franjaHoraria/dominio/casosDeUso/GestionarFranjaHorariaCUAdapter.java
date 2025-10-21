package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarCursoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarFranjaHorariaPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.ValidacionHandler;

public class GestionarFranjaHorariaCUAdapter implements GestionarFranjaHorariaCUIntPort {

    private final GestionarFranjaHorariaPersistIntPort gestionarFranjaHorariaPersistIntPort;
    private final GestionarEspacioFisicoPersistIntPort gestionarEspacioFisicoPersistIntPort;
    private final GestionarDocentePersistIntPort gestionarDocentePersistIntPort;
    private final GestionarCursoPersistIntPort gestionarCursoPersistIntPort;
    protected final FormateadorResultadosIntPort objFormateadorResultados;
    private final ValidacionHandler cadenaValidaciones;

    public GestionarFranjaHorariaCUAdapter(
        GestionarFranjaHorariaPersistIntPort gestionarFranjaHorariaPersistIntPort, 
        GestionarCursoPersistIntPort gestionarCursoPersistIntPort, 
        GestionarEspacioFisicoPersistIntPort gestionarEspacioFisicoPersistIntPort, 
        ValidacionHandler cadenaValidaciones, 
        FormateadorResultadosIntPort objFormateadorResultados,
        GestionarDocentePersistIntPort gestionarDocentePersistIntPort) {
        this.gestionarFranjaHorariaPersistIntPort = gestionarFranjaHorariaPersistIntPort;
        this.gestionarCursoPersistIntPort = gestionarCursoPersistIntPort;
        this.gestionarEspacioFisicoPersistIntPort = gestionarEspacioFisicoPersistIntPort;
        this.cadenaValidaciones = cadenaValidaciones;
        this.objFormateadorResultados = objFormateadorResultados;
        this.gestionarDocentePersistIntPort = gestionarDocentePersistIntPort;
    }

    @Override
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria, Integer idCurso, Integer idEspacioFisico) {
        Curso cursoAsociado = this.gestionarCursoPersistIntPort.obtenerCursoById(idCurso);
        if(cursoAsociado == null){
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste("El curso no existe");
        }
        EspacioFisico espacioFisicoAsociado = this.gestionarEspacioFisicoPersistIntPort.obtenerEspacioFisicoById(idEspacioFisico);
        franjaHoraria.setObjCurso(cursoAsociado);
        franjaHoraria.setObjEspacioFisico(espacioFisicoAsociado);
        this.cadenaValidaciones.validar(franjaHoraria);
        return this.gestionarFranjaHorariaPersistIntPort.crearFranjaHoraria(franjaHoraria);
    }

    @Override
    public void eliminarFranjasPorCurso(Integer idCurso) {
        boolean curso = this.gestionarCursoPersistIntPort.existsById(idCurso);
        if (!curso) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste("El curso no existe");
        }
        this.gestionarFranjaHorariaPersistIntPort.eliminarFranjasPorCurso(idCurso);
    }

    @Override
    public List<FranjaHoraria> findByDocenteId(Integer docenteId) {
        boolean docente = this.gestionarDocentePersistIntPort.existePorId(docenteId);
        if (!docente) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste("El docente no existe");
        }
        return this.gestionarFranjaHorariaPersistIntPort.encontrarByDocenteId(docenteId);
    }

    @Override
    public List<FranjaHoraria> findByCursoId(Integer cursoId) {
        boolean cursoAsociado = this.gestionarCursoPersistIntPort.existsById(cursoId);
        if (!cursoAsociado) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste("El curso no existe");
        }
        return this.gestionarFranjaHorariaPersistIntPort.encontrarByCursoId(cursoId);

    }

    @Override
    public List<FranjaHoraria> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
