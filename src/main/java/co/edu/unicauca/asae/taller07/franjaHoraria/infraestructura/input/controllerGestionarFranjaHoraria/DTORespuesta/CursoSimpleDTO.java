package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTORespuesta.AsignaturaDTORespuesta;
import lombok.Data;

@Data
public class CursoSimpleDTO {
    private Integer id;
    private String nombre;
    private Integer cupo;
    private AsignaturaDTORespuesta objAsignatura;
    private List<DocenteSimpleDTO> docentes;
}
