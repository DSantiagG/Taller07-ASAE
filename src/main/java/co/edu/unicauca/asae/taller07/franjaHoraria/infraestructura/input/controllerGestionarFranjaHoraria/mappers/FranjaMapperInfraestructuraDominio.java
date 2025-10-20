package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDTORespuesta;

@Mapper(componentModel = "spring")
public interface FranjaMapperInfraestructuraDominio {
    FranjaHoraria mappearDePeticionAFranjaHoraria(FranjaHorariaDTOPeticion franjaHorariaDTOPeticion);
    FranjaHorariaDTORespuesta mappearDeFranjaHorariaARespuesta(FranjaHoraria franjaHoraria);
    List<FranjaHorariaDTORespuesta> mappearDeListaFranjaHorariaARespuesta(List<FranjaHoraria> franjasHorarias);
}
