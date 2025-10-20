package co.edu.unicauca.asae.taller07.docente.aplicacion.output;

import java.time.LocalTime;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;

public interface GestionarDocentePersistIntPort {
    boolean estaDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin);

    boolean existePorCorreo(String correo);

    boolean existePorId(Integer idDocente);

    Docente guardar(Docente nuevoDocente);
}