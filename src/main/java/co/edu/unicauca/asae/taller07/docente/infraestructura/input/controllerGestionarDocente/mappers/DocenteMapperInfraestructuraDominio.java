package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;


@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {

    DocenteDTORespuesta aDtoRespuesta(Docente docente);

    @Mapping(target = "cursos", ignore = true)
    @Mapping(target = "objOficina.docentes", ignore = true)
    @Mapping(target = "objOficina.id", ignore = true)
    @Mapping(target = "id", ignore = true)
    Docente aDominio(DocenteDTOPeticion docenteDto);

}
