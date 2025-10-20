package co.edu.unicauca.asae.taller07.docente.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.docente.dominio.casosDeUso.GestionarDocenteCUAdapter;


@Configuration
public class ConfigDominioDocente {

    @Bean
    public GestionarDocenteCUAdapter GestionarDocenteCUIntPort(GestionarDocentePersistIntPort gestionarDocentePersist,FormateadorResultadosIntPort formateadorResultados) {
        return new GestionarDocenteCUAdapter(gestionarDocentePersist, formateadorResultados);
    }

}
