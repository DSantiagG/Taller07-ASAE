package co.edu.unicauca.asae.taller07.docente.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.docente.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarCursoCUIntPort;


@Configuration
public class ConfigDominioDocente {

    @Bean
    public GestionarDocenteCUAdapter GestionarDocenteCUIntPort(GestionarDocentePersistIntPort gestionarDocentePersist,FormateadorResultadosIntPort formateadorResultados,GestionarCursoCUIntPort gestionarCursoCU) {
        return new GestionarDocenteCUAdapter(gestionarDocentePersist, gestionarCursoCU, formateadorResultados);
    }

}
