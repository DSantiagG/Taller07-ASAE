package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain;

import java.util.Optional;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;

public class EspacioFisicoActivoHandler extends ValidacionHandler{

    private final EspacioFisicoRepository espacioFisicoRepository;

    public EspacioFisicoActivoHandler(EspacioFisicoRepository espacioFisicoRepository, FormateadorResultadosIntPort objFormateadorResultados) {
        super(objFormateadorResultados);
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    @Override
    public void validar(FranjaHoraria franja){
        System.out.println("Validando que el espacio físico esté activo...");
        Optional<EspacioFisicoEntity> espacioFisico = this.espacioFisicoRepository.findById(franja.getObjEspacioFisico().getId());

        //TODO: Cambiar mensaje de error
        if(espacioFisico.isEmpty()){
            this.objFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("El espacio físico no existe");
        }

        if (!espacioFisico.get().getEstado()) {
            this.objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("El espacio físico no se encuentra activo");
        }

        // Si hay un siguiente handler en la cadena, pasar la validación al siguiente
        if (this.siguienteHandler != null) {
            this.siguienteHandler.validar(franja);
        }
    }

   

}
