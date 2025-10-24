package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Oficina;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.OficinaDTORespuesta;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;

@Component
public class FranjaPorCursoMapper {

    public List<FranjaHorariaDeCursoDTORespuesta> mappearListaDeFranjaHorariaACursoRespuesta(
            List<FranjaHoraria> franjas) {
        return franjas.stream()
                .map(this::mappearDeFranjaHorariaACursoRespuesta)
                .collect(Collectors.toList());
    }

    public FranjaHorariaDeCursoDTORespuesta mappearDeFranjaHorariaACursoRespuesta(FranjaHoraria franja) {
        FranjaHorariaDeCursoDTORespuesta franjaHorariaDeCursoDTORespuesta = new FranjaHorariaDeCursoDTORespuesta();
        franjaHorariaDeCursoDTORespuesta.setId(franja.getId());
        franjaHorariaDeCursoDTORespuesta.setDia(franja.getDia());
        franjaHorariaDeCursoDTORespuesta.setHoraInicio(franja.getHoraInicio());
        franjaHorariaDeCursoDTORespuesta.setHoraFin(franja.getHoraFin());

        if (franja.getObjEspacioFisico() != null) {
            franjaHorariaDeCursoDTORespuesta.setObjEspacioFisico(mappearEspacioFisico(franja.getObjEspacioFisico()));
        }

        if (franja.getObjCurso() != null && franja.getObjCurso().getDocentes() != null) {
            franjaHorariaDeCursoDTORespuesta.setObjDocente(mappearDocentes(franja.getObjCurso().getDocentes()));
        }

        return franjaHorariaDeCursoDTORespuesta;
    }

    private EspacioFisicoDTORespuesta mappearEspacioFisico(EspacioFisico espacio) {
        EspacioFisicoDTORespuesta espacioFisicoDTORespuesta = new EspacioFisicoDTORespuesta();
        espacioFisicoDTORespuesta.setId(espacio.getId());
        espacioFisicoDTORespuesta.setNombre(espacio.getNombre());
        espacioFisicoDTORespuesta.setCapacidad(espacio.getCapacidad());
        espacioFisicoDTORespuesta.setEstado(espacio.getEstado());
        espacioFisicoDTORespuesta.setUbicacion(espacio.getUbicacion());
        espacioFisicoDTORespuesta.setTipo(espacio.getTipo());
        return espacioFisicoDTORespuesta;
    }

    private List<DocenteDTORespuesta> mappearDocentes(List<Docente> docentes) {
        return docentes.stream()
                .map(this::mappearDocente)
                .collect(Collectors.toList());
    }

    private DocenteDTORespuesta mappearDocente(Docente docente) {
        DocenteDTORespuesta docenteDTORespuesta = new DocenteDTORespuesta();
        docenteDTORespuesta.setId(docente.getId());
        docenteDTORespuesta.setNombre(docente.getNombre());
        docenteDTORespuesta.setApellido(docente.getApellido());
        docenteDTORespuesta.setCorreo(docente.getCorreo());
        docenteDTORespuesta.setIdentificacion(docente.getIdentificacion());
        if(docente.getObjOficina() != null){
            docenteDTORespuesta.setObjOficina(mappearOficina(docente.getObjOficina()));
        }
        return docenteDTORespuesta;
    }

    private OficinaDTORespuesta mappearOficina(Oficina oficina) {
        OficinaDTORespuesta oficinaDTORespuesta = new OficinaDTORespuesta();
        oficinaDTORespuesta.setId(oficina.getId());
        oficinaDTORespuesta.setNombre(oficina.getNombre());
        oficinaDTORespuesta.setUbicacion(oficina.getUbicacion());
        return oficinaDTORespuesta;
    }

}
