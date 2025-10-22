package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain;
import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.CadenaResponsabilidadIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public class EspacioFisicoDisponibleHandler extends ValidacionHandler {

    
    public EspacioFisicoDisponibleHandler(FormateadorResultadosIntPort objFormateadorResultados, CadenaResponsabilidadIntPort objCadenaResponsabilidad) {
        super(objFormateadorResultados, objCadenaResponsabilidad);
    }

    @Override
    public void validar(FranjaHoraria franja){
        System.out.println("Validando disponibilidad del espacio físico...");
        boolean espacioFisicoDisponible = objCadenaResponsabilidad.estaEspacioFisicoDisponible(franja.getObjEspacioFisico().getId(), franja.getDia(), franja.getHoraInicio(), franja.getHoraFin());

        if (!espacioFisicoDisponible) {
            this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("El espacio físico no está disponible en la franja horaria especificada");
        }

        // Si hay un siguiente handler en la cadena, pasar la validación al siguiente
        if (this.siguienteHandler != null) {
            this.siguienteHandler.validar(franja);
        }
    }


}
