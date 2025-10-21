package co.edu.unicauca.asae.taller07.commons.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

@Configuration
public class PersistenciaMapper {

    @Bean
    public ModelMapper crearPersistenciaMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(FranjaHorariaEntity.class, FranjaHoraria.class)
          .addMappings(m -> m.skip(FranjaHoraria::setObjCurso));
          System.out.println("✅ TypeMap creado: " + mapper.getTypeMap(FranjaHorariaEntity.class, FranjaHoraria.class));

        return mapper;
    }

}
