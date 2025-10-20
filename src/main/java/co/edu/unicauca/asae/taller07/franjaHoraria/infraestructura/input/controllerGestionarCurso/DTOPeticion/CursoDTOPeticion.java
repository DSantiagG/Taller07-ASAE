package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTOPeticion;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTOPeticion {
    
    @NotBlank(message = "{curso.nombre.notblank}")
    @Size(min = 3, max = 100, message = "{curso.nombre.size}")
    private String nombre;
    
    @NotNull(message = "{curso.cupo.notnull}")
    @Positive(message = "{curso.cupo.positive}")
    private Integer cupo;
    
    @NotNull(message = "{curso.asignatura.notnull}")
    private Integer asignaturaId;
    
    private List<Integer> franjaHorariaIds;
    
    @NotEmpty(message = "{curso.docentes.notempty}")
    private List<Integer> docenteIds;
}
