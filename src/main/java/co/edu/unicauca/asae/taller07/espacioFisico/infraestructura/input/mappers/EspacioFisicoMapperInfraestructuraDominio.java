package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.DTOPeticion.EspacioFisicoDTOPeticion;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.DTORespuesta.EspacioFisicoDTORespuesta;

@Mapper(componentModel = "spring")
public interface EspacioFisicoMapperInfraestructuraDominio {
    EspacioFisico mappearDePeticionAEspacioFisico(EspacioFisicoDTOPeticion peticion);

    EspacioFisicoDTORespuesta mappearDeEspacioFisicoAEspacioFisicoDTORespuesta(EspacioFisico espacioFisico);

    List<EspacioFisicoDTORespuesta> mappearDeEspaciosFisicosAEspacioFisicoDTORespuesta(List<EspacioFisico> espaciosFisicos);
}