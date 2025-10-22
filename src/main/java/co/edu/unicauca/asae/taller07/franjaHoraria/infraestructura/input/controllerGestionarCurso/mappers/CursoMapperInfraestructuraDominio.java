package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTOPeticion.CursoDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuesta;

@Mapper(componentModel = "spring")
public interface CursoMapperInfraestructuraDominio {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "docentes", ignore = true)
    @Mapping(target = "franjasHorarias", ignore = true)
    @Mapping(target = "objAsignatura", ignore = true)
    Curso mappearDePeticionACurso(CursoDTOPeticion peticion);

    CursoDTORespuesta mappearDeCursoARespuesta(Curso objCurso);

    List<CursoDTORespuesta> mappearDeCursosARespuesta(List<Curso> cursos);
}