package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.CadenaResponsabilidadIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public class EspacioFisicoActivoHandler extends ValidacionHandler {

    public EspacioFisicoActivoHandler(FormateadorResultadosIntPort objFormateadorResultados, CadenaResponsabilidadIntPort objCadenaResponsabilidad) {
        super(objFormateadorResultados, objCadenaResponsabilidad);
    }

    @Override
    public void validar(FranjaHoraria franja) {
        System.out.println("Validando que el espacio físico esté activo...");
        EspacioFisico espacioFisico = this.objCadenaResponsabilidad.obtenerEspacioFisicoById(franja.getObjEspacioFisico().getId());

        if (espacioFisico == null) {
            this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("El espacio físico no existe");
        } else {
            if (!espacioFisico.getEstado()) {
                this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("El espacio físico no se encuentra activo");
            }
        }

        // Si hay un siguiente handler en la cadena, pasar la validación al siguiente
        if (this.siguienteHandler != null) {
            this.siguienteHandler.validar(franja);
        }
    }

}
