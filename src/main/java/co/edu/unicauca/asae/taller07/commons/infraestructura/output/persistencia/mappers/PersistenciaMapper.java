package co.edu.unicauca.asae.taller07.commons.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;

@Configuration
public class PersistenciaMapper {

    @Bean("mapperConSkip")
    @Primary
    public ModelMapper crearPersistenciaMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<FranjaHorariaEntity, FranjaHoraria> mapa1 = mapper.emptyTypeMap(FranjaHorariaEntity.class, FranjaHoraria.class);
        mapa1.addMappings(n -> n.skip(FranjaHoraria::setObjCurso)).implicitMappings();
        TypeMap<DocenteEntity, Docente> mapa2 = mapper.emptyTypeMap(DocenteEntity.class, Docente.class);
        mapa2.addMappings(n -> n.skip(Docente::setCursos)).implicitMappings();
        return mapper;
    }

    @Bean("mapperNormal")
    public ModelMapper crearMapperNormal() {
        return new ModelMapper();
    }

}
