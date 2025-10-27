package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarFranjaHorariaPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepository;

@Service
public class GestionarFranjaHorariaPersistImpl implements GestionarFranjaHorariaPersistIntPort {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final ModelMapper objMapper;
    private final ModelMapper objMapperConSkip;

    public GestionarFranjaHorariaPersistImpl(
        FranjaHorariaRepository franjaHorariaRepository, 
        @Qualifier("mapperNormal")
        ModelMapper objMapper, 
        @Qualifier("mapperConSkip")
        ModelMapper objMapperConSkip) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.objMapper = objMapper;
        this.objMapperConSkip = objMapperConSkip;
    }

    @Override
    @Transactional
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria) {
        FranjaHorariaEntity franjaHorariaEntity = objMapper.map(franjaHoraria, FranjaHorariaEntity.class);
        FranjaHorariaEntity franjaHorariaEntityGuardada = franjaHorariaRepository.save(franjaHorariaEntity);
        return objMapper.map(franjaHorariaEntityGuardada, FranjaHoraria.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FranjaHoraria> encontrarByCursoId(Integer cursoId) {
        List<FranjaHorariaEntity> franjasEntities = franjaHorariaRepository.findByObjCursoId(cursoId);
        System.out.println("------Antes de mapear las franjas-------\n");
        //List<FranjaHoraria> franjas = this.objMapper.map(franjasEntities, new TypeToken<List<FranjaHoraria>>() {}.getType());
        List<FranjaHoraria> franjas = franjasEntities.stream()
                .map(entity -> this.objMapperConSkip.map(entity, FranjaHoraria.class))
                .toList();
        System.out.println("------Después de mapear las franjas-------\n");
        return franjas;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FranjaHoraria> encontrarByDocenteId(Integer docenteId) {
        List<FranjaHorariaEntity> franjasEntities = franjaHorariaRepository.findByObjDocenteId(docenteId);
        List<FranjaHoraria> franjas = this.objMapper.map(franjasEntities, new TypeToken<List<FranjaHoraria>>() {}.getType());
        return franjas;
    }

    @Override
    @Transactional
    public void eliminarFranjasPorCurso(Integer cursoId) {
        this.franjaHorariaRepository.eliminarFranjasPorCurso(cursoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FranjaHoraria> listarFranjas() {
        List<FranjaHorariaEntity> franjasEntities = franjaHorariaRepository.findAll();
        List<FranjaHoraria> franjas = this.objMapper.map(franjasEntities, new TypeToken<List<FranjaHoraria>>() {}.getType());
        return franjas;
    }
    
}
