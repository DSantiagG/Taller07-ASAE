package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaMapperInfraestructuraDominio {
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion franjaHorariaDTOPeticion);
    FranjaHorariaDeDocenteDTORespuesta mappearDeFranjaHorariaDeDocenteARespuesta(FranjaHoraria franjaHoraria);
    List<FranjaHorariaDeDocenteDTORespuesta> mappearDeListaFranjaHorariaDeDocenteARespuesta(List<FranjaHoraria> franjasHorarias);

    //@Mapping(target = "objCurso.franjasHorarias", ignore = true)// Evitar referencia circular
    @Mapping(target = "objCurso.objAsignatura", ignore =  true)
    @Mapping(target = "objCurso.cupo", ignore = true)
    @Mapping(target = "objCurso.nombre", ignore = true)
    List<FranjaHorariaDeCursoDTORespuesta> mappearDeFranjaHorariaDeCursoARespuesta(List<FranjaHoraria> franjaHoraria);
}
