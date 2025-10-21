package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter@AllArgsConstructor
public class Curso {
    private Integer id;
    
    private String nombre;
    
    private int cupo;
    
    private Asignatura objAsignatura;
    
    private List<FranjaHoraria> franjasHorarias;
    
    private List<Docente> docentes;

    public Curso() {
        this.franjasHorarias = new ArrayList<>();
        this.docentes = new ArrayList<>();
    }

    public Curso(Integer id) {
        this.franjasHorarias = new ArrayList<>();
        this.docentes = new ArrayList<>();
        this.id=id;
    }
}
