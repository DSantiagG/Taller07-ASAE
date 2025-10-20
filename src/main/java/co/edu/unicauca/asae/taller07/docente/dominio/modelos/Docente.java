package co.edu.unicauca.asae.taller07.docente.dominio.modelos;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Docente extends Persona{
    private Oficina objOficina;

    private List<Curso> cursos;
}
