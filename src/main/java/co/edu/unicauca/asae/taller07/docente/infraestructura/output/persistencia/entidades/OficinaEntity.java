package co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "oficina")
@Getter@Setter@AllArgsConstructor
public class OficinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20, unique = true)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String ubicacion;

    @OneToMany(mappedBy = "objOficina")
    private List<DocenteEntity> docentes;

    public OficinaEntity() {
        this.docentes = new ArrayList<>();
    }

}
