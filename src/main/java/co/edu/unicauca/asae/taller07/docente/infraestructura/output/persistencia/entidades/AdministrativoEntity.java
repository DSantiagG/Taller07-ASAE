package co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter@Setter
public class AdministrativoEntity extends PersonaEntity {

    @Column(nullable = true, length = 255)
    private String rol;

    AdministrativoEntity(Integer id, String nombre, String apellido, String correo, String identificacion, String rol) {
        super(id, nombre, apellido, correo, identificacion);
        this.rol = rol;
    }
}
