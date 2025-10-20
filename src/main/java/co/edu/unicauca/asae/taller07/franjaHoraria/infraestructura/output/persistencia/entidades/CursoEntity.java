package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
@Entity
@Table(name = "curso")
@Getter@Setter@AllArgsConstructor
public class CursoEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false)
    private int cupo;

    @ManyToOne
    @JoinColumn(name = "asignatura_id", nullable = false)
    private AsignaturaEntity objAsignatura;

    @OneToMany(mappedBy = "objCurso",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<FranjaHorariaEntity> franjasHorarias;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "curso_docente", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "docente_id"))
    private List<DocenteEntity> docentes;

    public CursoEntity() {
        this.franjasHorarias = new ArrayList<>();
        this.docentes = new ArrayList<>();
    }

}