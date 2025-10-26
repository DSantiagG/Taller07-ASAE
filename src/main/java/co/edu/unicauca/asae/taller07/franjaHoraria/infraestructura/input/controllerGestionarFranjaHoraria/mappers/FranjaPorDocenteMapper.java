package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.CursoSimpleDTO;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.DocenteSimpleDTO;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;

@Component
public class FranjaPorDocenteMapper {
    public List<FranjaHorariaDeDocenteDTORespuesta> mappearDeListaFranjaHorariaDeDocenteARespuesta(List<FranjaHoraria> franjas) {
        if (franjas == null) return null;
        return franjas.stream()
                .map(this::mappearDeFranjaHorariaDeDocenteARespuesta)
                .collect(Collectors.toList());
    }

    public FranjaHorariaDeDocenteDTORespuesta mappearDeFranjaHorariaDeDocenteARespuesta(FranjaHoraria franja) {
        if (franja == null) return null;

        FranjaHorariaDeDocenteDTORespuesta dto = new FranjaHorariaDeDocenteDTORespuesta();
        dto.setId(franja.getId());
        dto.setHoraInicio(franja.getHoraInicio());
        dto.setHoraFin(franja.getHoraFin());
        dto.setDia(franja.getDia());

        // Mapear espacio físico (usando método propio)
        if (franja.getObjEspacioFisico() != null) {
            dto.setObjEspacioFisico(mapearEspacioFisico(franja.getObjEspacioFisico()));
        }

        // Mapear el curso
        if (franja.getObjCurso() != null) {
            Curso curso = franja.getObjCurso();
            CursoSimpleDTO cursoDTO = new CursoSimpleDTO();
            cursoDTO.setId(curso.getId());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setCupo(curso.getCupo());

            // Docentes simplificados (sin cursos)
            if (curso.getDocentes() != null) {
                List<DocenteSimpleDTO> docentesSimples = curso.getDocentes().stream()
                        .map(this::mapearDocenteSimple)
                        .collect(Collectors.toList());
                cursoDTO.setDocentes(docentesSimples);
            }
            dto.setObjCurso(cursoDTO);
        }

        return dto;
    }

    /**
     * Convierte un docente en un DTO simple sin cursos
     */
    private DocenteSimpleDTO mapearDocenteSimple(Docente docente) {
        if (docente == null) return null;
        DocenteSimpleDTO dto = new DocenteSimpleDTO();
        dto.setId(docente.getId());
        dto.setNombre(docente.getNombre());
        dto.setApellido(docente.getApellido());
        dto.setCorreo(docente.getCorreo());
        dto.setIdentificacion(docente.getIdentificacion());
        return dto;
    }

    /**
     * Convierte un EspacioFisico de dominio en un DTO
     */
    private EspacioFisicoDTORespuesta mapearEspacioFisico(EspacioFisico espacio) {
        if (espacio == null) return null;
        EspacioFisicoDTORespuesta dto = new EspacioFisicoDTORespuesta();
        dto.setId(espacio.getId());
        dto.setNombre(espacio.getNombre());
        dto.setUbicacion(espacio.getUbicacion());
        dto.setCapacidad(espacio.getCapacidad());
        dto.setTipo(espacio.getTipo());
        return dto;
    }
}
