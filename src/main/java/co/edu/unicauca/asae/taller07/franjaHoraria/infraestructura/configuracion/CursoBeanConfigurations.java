package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarCursoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.casosDeUso.GestionarCursoCUAdapter;

@Configuration
public class CursoBeanConfigurations {
    
    @Bean
    public GestionarCursoCUAdapter crearGestionarCursoCUInt (GestionarCursoPersistIntPort objGestionarCursoPersist, FormateadorResultadosIntPort objFormateadorResultados) {
        GestionarCursoCUAdapter objGestionarCursoCU = new GestionarCursoCUAdapter(objGestionarCursoPersist, objFormateadorResultados);
        return objGestionarCursoCU;
    }
}
