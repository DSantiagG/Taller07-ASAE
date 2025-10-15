package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades;

import lombok.Setter;
import lombok.Getter;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "asignatura")
@Getter@Setter@AllArgsConstructor
public class AsignaturaEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String codigo;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false)
    private int numeroCreditos;

    @OneToMany(mappedBy = "objAsignatura", fetch = FetchType.EAGER)
    private List<CursoEntity> cursos;

    public AsignaturaEntity() {

    }

}
