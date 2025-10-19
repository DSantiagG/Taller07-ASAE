package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumTipoEspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.DTORespuesta.FranjaHorariaDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisicoDTORespuesta {
    private Integer id;

    private String nombre;

    private String ubicacion;

    private Boolean estado;

    private Integer capacidad;

    private EnumTipoEspacioFisico tipo;

    private List<FranjaHorariaDTORespuesta> franjasHorarias;
}
