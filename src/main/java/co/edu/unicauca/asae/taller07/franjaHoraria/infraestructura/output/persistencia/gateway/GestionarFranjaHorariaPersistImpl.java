package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

    public GestionarFranjaHorariaPersistImpl(FranjaHorariaRepository franjaHorariaRepository, ModelMapper objMapper) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.objMapper = objMapper;
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
        List<FranjaHorariaEntity> franjasEntities = franjaHorariaRepository.findFranjasByCursoIdSinCurso(cursoId);
        List<FranjaHoraria> franjas = this.objMapper.map(franjasEntities, new TypeToken<List<FranjaHoraria>>() {}.getType());
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
