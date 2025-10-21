package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class OficinaDTOPeticion {
    
    @NotNull
    private String nombre;
    @NotNull
    private String ubicacion;
}
