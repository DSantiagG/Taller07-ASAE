package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//TODO: VALIDACIONES DE ENTRADA
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class DocenteDTOPeticion {
   
    private String nombre;

    private String apellido;

    private String correo;

    private String identificacion;

    private OficinaDTOPeticion objOficina;

    private List<Integer> cursos;

}
