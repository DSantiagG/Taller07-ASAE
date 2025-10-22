package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class OficinaDTOPeticion {

    @NotBlank(message = "{oficina.nombre.notblank}")
    private String nombre;
    @NotBlank(message = "{oficina.ubicacion.notblank}")
    private String ubicacion;
}
