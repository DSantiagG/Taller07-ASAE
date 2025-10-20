package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTORespuesta {

    private Integer id;

    private String nombre;

    private int cupo;

    private AsignaturaDTORespuesta objAsignatura;

    private List<DocenteDTORespuesta> docentes;
}