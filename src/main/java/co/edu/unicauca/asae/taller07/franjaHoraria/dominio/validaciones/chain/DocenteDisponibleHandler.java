package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain;
import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.CadenaResponsabilidadIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;



public class DocenteDisponibleHandler extends ValidacionHandler {

    
    public DocenteDisponibleHandler(FormateadorResultadosIntPort objFormateadorResultados,CadenaResponsabilidadIntPort objCadenaResponsabilidad) {
        super(objFormateadorResultados, objCadenaResponsabilidad);
    }
    @Override
    public void validar(FranjaHoraria franja){
        // Lógica para validar si el docente está disponible en la franja horaria dada
        System.out.println("Validando disponibilidad del docente...");

        franja.getObjCurso().getDocentes().forEach(docente -> {
            boolean docenteDisponible = this.objCadenaResponsabilidad.estaDocenteDisponible(docente.getId(), franja.getDia(), franja.getHoraInicio(), franja.getHoraFin());
            if (!docenteDisponible) {
                this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("El docente " + docente.getNombre() +" " + docente.getApellido() + " no está disponible en la franja horaria especificada.");
            }
        });

        // Si hay un siguiente handler en la cadena, pasar la validación al siguiente
        if (this.siguienteHandler != null) {
            this.siguienteHandler.validar(franja);
        }
    }


}
