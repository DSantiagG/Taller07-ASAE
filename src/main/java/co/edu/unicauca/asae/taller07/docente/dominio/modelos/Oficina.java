package co.edu.unicauca.asae.taller07.docente.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter@AllArgsConstructor
public class Oficina {

    private Integer id;

    private String nombre;

    private String ubicacion;

    private List<Docente> docentes;

    public Oficina() {
        this.docentes = new ArrayList<>();
    }
}
