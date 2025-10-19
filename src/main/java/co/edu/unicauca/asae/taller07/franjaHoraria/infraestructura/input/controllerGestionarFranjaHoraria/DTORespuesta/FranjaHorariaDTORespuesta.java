package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controllerGestionarEspacioFisico.DTORespuesta.EspacioFisicoDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDTORespuesta {

    private Integer id;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private EnumDias dia;

    private EspacioFisicoDTORespuesta objEspacioFisico;

    private CursoDTORespuesta objCurso;
}
