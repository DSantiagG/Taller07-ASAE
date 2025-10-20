package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
//import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTOPeticion.CursoDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuesta;

@Mapper(componentModel = "spring")
public interface CursoMapperInfraestructuraDominio {
    //Curso mappearDePeticionACurso(CursoDTOPeticion peticion);
    CursoDTORespuesta mappearDeCursoARespuesta(Curso objCurso);
    List<CursoDTORespuesta> mappearDeCursosARespuesta(List<Curso> cursos);
}