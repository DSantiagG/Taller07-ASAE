package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuestaDocente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta extends PersonaDTORespuesta {
    private OficinaDTORespuesta objOficina;
    private List<CursoDTORespuestaDocente> cursos;
}
