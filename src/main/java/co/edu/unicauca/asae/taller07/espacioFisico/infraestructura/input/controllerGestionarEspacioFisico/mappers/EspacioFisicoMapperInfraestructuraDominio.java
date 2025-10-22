package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.DTOPeticion.EspacioFisicoDTOPeticion;

@Mapper(componentModel = "spring")
public interface EspacioFisicoMapperInfraestructuraDominio {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "franjasHorarias", ignore = true)
    EspacioFisico mappearDePeticionAEspacioFisico(EspacioFisicoDTOPeticion peticion);

    EspacioFisicoDTORespuesta mappearDeEspacioFisicoAEspacioFisicoDTORespuesta(EspacioFisico espacioFisico);

    List<EspacioFisicoDTORespuesta> mappearDeEspaciosFisicosAEspacioFisicoDTORespuesta(List<EspacioFisico> espaciosFisicos);
}