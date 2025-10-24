package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.validaciones.CapacidadValida;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.validaciones.FormatoMilitar;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@CapacidadValida
public class FranjaHorariaDTOPeticion {
    @NotNull(message = "{franjaHoraria.horaInicio.notNull}")
    @FormatoMilitar
    private LocalTime horaInicio;

    @NotNull(message = "{franjaHoraria.horaFin.notNull}")
    @FormatoMilitar
    private LocalTime horaFin;

    @NotNull(message = "{franjaHoraria.dia.notNull}")
    private EnumDias dia;

    @NotNull(message = "{franjaHoraria.idEspacioFisico.notNull}")
    @Min(value = 1, message = "{franjaHoraria.idEspacioFisico.minimo}")
    private Integer idEspacioFisico;

    @NotNull(message = "{franjaHoraria.idCurso.notNull}")
    @Min(value = 1, message = "{franjaHoraria.idCurso.minimo}")
    private Integer idCurso;
}
