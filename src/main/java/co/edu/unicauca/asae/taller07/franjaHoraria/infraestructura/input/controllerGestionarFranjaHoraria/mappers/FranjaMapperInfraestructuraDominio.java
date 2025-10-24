package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaMapperInfraestructuraDominio {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "objCurso", ignore = true)
    @Mapping(target = "objEspacioFisico", ignore = true)
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion franjaHorariaDTOPeticion);
    FranjaHorariaDeDocenteDTORespuesta mappearDeFranjaHorariaDeDocenteARespuesta(FranjaHoraria franjaHoraria);
    List<FranjaHorariaDeDocenteDTORespuesta> mappearDeListaFranjaHorariaDeDocenteARespuesta(List<FranjaHoraria> franjasHorarias);

}
