package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Asignatura {

    private Integer id;

    private String codigo;

    private String nombre;

    private int numeroCreditos;

    private List<Curso> cursos;
}
