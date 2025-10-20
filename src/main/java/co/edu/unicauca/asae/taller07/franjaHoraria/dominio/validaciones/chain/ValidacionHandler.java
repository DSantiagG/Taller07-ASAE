package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain;


import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public abstract class ValidacionHandler {

    protected ValidacionHandler siguienteHandler;
    protected final FormateadorResultadosIntPort objFormateadorResultados;

    public ValidacionHandler(FormateadorResultadosIntPort objFormateadorResultados) {
        this.objFormateadorResultados = objFormateadorResultados;
    }

    public void setNext(ValidacionHandler siguienteHandler) {
        this.siguienteHandler = siguienteHandler;
    }

    public abstract void validar(FranjaHoraria franja);


}
