package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarCursoCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarCursoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;

public class GestionarCursoCUAdapter implements GestionarCursoCUIntPort {

    private final GestionarCursoPersistIntPort objGestionarCursoPersist;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarCursoCUAdapter(GestionarCursoPersistIntPort objGestionarCursoPersist, FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarCursoPersist = objGestionarCursoPersist;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<Curso> findByAsignaturaNombre(String nombreAsignatura) {
        List<Curso> listaObtenida = objGestionarCursoPersist.findByAsignaturaNombre(nombreAsignatura);
        return listaObtenida;
    }

    @Override
    public Curso obtenerCursoById(Integer idCurso) {
        if (!objGestionarCursoPersist.existsById(idCurso)) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error, el curso con id " + idCurso + " no existe.");
        }
        Curso cursoObtenido = objGestionarCursoPersist.obtenerCursoById(idCurso);
        return cursoObtenido;
    }
}
