package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.DTOPeticion;

import java.util.List;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumTipoEspacioFisico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisicoDTOPeticion {

    @NotBlank(message = "{espacioFisico.nombre.notblank}")
    @Size(min = 3, max = 100, message = "{espacioFisico.nombre.size}")
    private String nombre;
    
    @NotBlank(message = "{espacioFisico.ubicacion.notblank}")
    @Size(max = 200, message = "{espacioFisico.ubicacion.size}")
    private String ubicacion;
    
    @NotNull(message = "{espacioFisico.estado.notnull}")
    private Boolean estado;
    
    @NotNull(message = "{espacioFisico.capacidad.notnull}")
    @Positive(message = "{espacioFisico.capacidad.positive}")
    private Integer capacidad;
    
    @NotNull(message = "{espacioFisico.tipo.notnull}")
    private EnumTipoEspacioFisico tipo;

    private List<Integer> franjaHorariaIds;
}
