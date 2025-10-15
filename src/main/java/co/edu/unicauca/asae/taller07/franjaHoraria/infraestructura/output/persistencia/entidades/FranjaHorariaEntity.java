package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "franja_horaria")
@Getter@Setter@AllArgsConstructor
public class FranjaHorariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="hora_inicio",nullable = false)
    private LocalTime horaInicio;
    @Column(name="hora_fin",nullable = false)
    private LocalTime horaFin;
    @Enumerated(EnumType.STRING)
    @Column(name="dia",nullable = false)
    private EnumDias dia;

    @ManyToOne
    @JoinColumn(name = "espacio_fisico_id", nullable = true)
    private EspacioFisicoEntity objEspacioFisico;

    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity objCurso;

    public FranjaHorariaEntity() {
    }
}
