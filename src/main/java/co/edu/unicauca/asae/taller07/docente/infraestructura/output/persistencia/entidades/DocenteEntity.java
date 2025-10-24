package co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades;

import java.util.List;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter@Setter
public class DocenteEntity extends PersonaEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "oficina_id", nullable = true)
    private OficinaEntity objOficina;

    @ManyToMany(mappedBy = "docentes",fetch = FetchType.LAZY)
    private List<CursoEntity> cursos;

    DocenteEntity(Integer id, String nombre, String apellido, String correo, String identificacion, OficinaEntity objOficina) {
        super(id, nombre, apellido, correo, identificacion);
        this.objOficina = objOficina;
    }
    public DocenteEntity() {
        super();
    }

}
