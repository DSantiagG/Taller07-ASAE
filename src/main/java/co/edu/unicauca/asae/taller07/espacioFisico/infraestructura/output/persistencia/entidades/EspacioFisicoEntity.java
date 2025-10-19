package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades;

import java.util.List;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumTipoEspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "espacio_fisico")
@Getter@Setter@AllArgsConstructor
public class EspacioFisicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 255, unique = true)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String ubicacion;
    @Column(nullable = false)
    private Boolean estado;
    @Column(nullable = false)
    private int capacidad;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EnumTipoEspacioFisico tipo;

    @OneToMany(mappedBy = "objEspacioFisico",fetch = FetchType.EAGER)
    private List<FranjaHorariaEntity> franjasHorarias;

    public EspacioFisicoEntity() {
    }
}
