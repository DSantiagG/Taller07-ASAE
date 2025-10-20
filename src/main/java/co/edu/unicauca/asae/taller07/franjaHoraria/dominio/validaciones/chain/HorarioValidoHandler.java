package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain;
import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.CadenaResponsabilidadIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;


public class HorarioValidoHandler extends ValidacionHandler {

    private final LocalTime horaApertura = LocalTime.of(6, 0);
    private final LocalTime horaCierre = LocalTime.of(22, 0);

    public HorarioValidoHandler(FormateadorResultadosIntPort objFormateadorResultados, CadenaResponsabilidadIntPort objCadenaResponsabilidad) {
        super(objFormateadorResultados, objCadenaResponsabilidad);
    }

    @Override
    public void validar(FranjaHoraria franja) {
        // Lógica para validar si el horario es válido
        boolean horarioValido = checkHorarioValido(franja);

        //TODO: Cambiar mensaje de error
        if (!horarioValido) {
            this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("El franja horaria no esta dentro del horario valido ( 6 am a 10 pm)");
        }
        

        // Si hay un siguiente handler en la cadena, pasar la validación al siguiente
        if (this.siguienteHandler != null) {
            this.siguienteHandler.validar(franja);
        }
    }

    //No se debe permitir crear una franja horaria en horarios diferentes a 6 am a 10 pm y de lunes a sábado.
    private boolean checkHorarioValido(FranjaHoraria franja) {
        boolean estado=true;
        LocalTime horaInicio = franja.getHoraInicio();
        LocalTime horaFin = franja.getHoraFin();
        if (horaInicio.isBefore(horaApertura) || horaFin.isAfter(horaCierre) || horaInicio.equals(horaCierre) || horaInicio.isAfter(horaFin)) {
            estado=false;
        }
        return estado;
    }

}
