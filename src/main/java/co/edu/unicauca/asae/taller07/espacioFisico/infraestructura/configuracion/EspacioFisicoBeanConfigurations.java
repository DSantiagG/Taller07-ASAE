package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.casosDeUso.GestionarEspacioFisicoCUAdapter;

@Configuration
public class EspacioFisicoBeanConfigurations {

    @Bean
    public GestionarEspacioFisicoCUAdapter crearGestionarEspacioFisicoCUIntPort(GestionarEspacioFisicoPersistIntPort gestionarEspacioFisicoPersistIntPort,
                                                                         FormateadorResultadosIntPort formateadorResultadosIntPort) {
        GestionarEspacioFisicoCUAdapter objGestionarEspacioFisicoCU = new GestionarEspacioFisicoCUAdapter(gestionarEspacioFisicoPersistIntPort,
                                                                                      formateadorResultadosIntPort);
        return objGestionarEspacioFisicoCU;
    }

}
