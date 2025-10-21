package co.edu.unicauca.asae.taller07.docente.dominio.casosDeUso;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarCursoCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocentePersistIntPort objGestionarDocentePersist;
    private final GestionarCursoCUIntPort objGestionarCursoCU;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocentePersistIntPort gestionarDocentePersist,
            GestionarCursoCUIntPort gestionarCursoCU,
            FormateadorResultadosIntPort formateadorResultados) {
        this.objGestionarDocentePersist = gestionarDocentePersist;
        this.objGestionarCursoCU = gestionarCursoCU;
        this.objFormateadorResultados = formateadorResultados;
    }

    @Override
    public Docente crearDocente(Docente nuevoDocente) {
        Docente docenteCreado;

        if (nuevoDocente.getId() != null) {
            if (this.objGestionarDocentePersist.existePorId(nuevoDocente.getId())) {
                this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, Ya existe un docente con el codigo " + nuevoDocente.getId());
            }
        }

        if (this.objGestionarDocentePersist.existePorCorreo(nuevoDocente.getCorreo())) {
            this.objFormateadorResultados
                    .retornarRespuestaErrorReglaDeNegocio("Error, Ya existe un docente con el correo " + nuevoDocente.getCorreo());
        }

        for(Curso curso:nuevoDocente.getCursos()){
            Curso cursoBD = this.objGestionarCursoCU.obtenerCursoById(curso.getId());
            if(cursoBD==null){
                this.objFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("El curso no existe");
            }
            curso=cursoBD;
        }

        docenteCreado = this.objGestionarDocentePersist.guardar(nuevoDocente);

        return docenteCreado;
    }

}
