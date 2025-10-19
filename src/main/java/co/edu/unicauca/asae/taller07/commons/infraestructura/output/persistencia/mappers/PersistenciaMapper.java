package co.edu.unicauca.asae.taller07.commons.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenciaMapper {

    @Bean
    public ModelMapper crearPersistenciaMapper() {
        return new ModelMapper();
    }

}
