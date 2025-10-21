package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarFranjaHorariaPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepository;

@Service
public class GestionarFranjaHorariaPersistImpl implements GestionarFranjaHorariaPersistIntPort {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final ModelMapper objMapper;

    public GestionarFranjaHorariaPersistImpl(FranjaHorariaRepository franjaHorariaRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.objMapper = new ModelMapper();
    }

    @Override
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria) {
        FranjaHorariaEntity franjaHorariaEntity = objMapper.map(franjaHoraria, FranjaHorariaEntity.class);
        FranjaHorariaEntity franjaHorariaEntityGuardada = franjaHorariaRepository.save(franjaHorariaEntity);
        return objMapper.map(franjaHorariaEntityGuardada, FranjaHoraria.class);
    }

    @Override
    public List<FranjaHoraria> findByCursoId(Integer cursoId) {
        List<FranjaHorariaEntity> franjasEntities = franjaHorariaRepository.findByObjCursoId(cursoId);
        List<FranjaHoraria> franjas = this.objMapper.map(franjasEntities, new TypeToken<List<FranjaHoraria>>() {}.getType());
        return franjas;
    }
    
}
