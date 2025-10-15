package co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumTipoEspacioFisico;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class EspacioFisico {

    private Integer id;

    private String nombre;

    private String ubicacion;

    private Boolean estado;

    private int capacidad;

    private EnumTipoEspacioFisico tipo;

    private List<FranjaHoraria> franjasHorarias;
}
