package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//TODO: Mensajes de validacion

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOPeticion {

    @NotBlank(message = "{docente.nombre.notblank}")
    private String nombre;

    @NotBlank(message = "{docente.apellido.notblank}")
    private String apellido;

    @NotBlank(message = "{docente.correo.notblank}")
    @Email(message = "{docente.correo.formatoInvalido}")
    private String correo;

    @Pattern(regexp = "\\d+", message = "{docente.identificacion.soloNumeros}")
    @NotBlank(message = "{docente.identificacion.notblank}")
    private String identificacion;

    @Valid
    private OficinaDTOPeticion objOficina;

    private List<Integer> cursos;

}
