package co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos;

import java.time.LocalTime;
import java.util.List;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class FranjaHoraria {
    
    private Integer id;
    
    private LocalTime horaInicio;
    
    private LocalTime horaFin;
    
    private EnumDias dia;
    
    private EspacioFisico objEspacioFisico;

    private Curso objCurso;

    private List<Docente> objDocentes;
}
