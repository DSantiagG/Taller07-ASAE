package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarFranjaHorariaPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.FranjaHorariaEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepository;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios.FranjaHorariaRepository;

@Service
public class GestionarFranjaHorariaPersistImpl implements GestionarFranjaHorariaPersistIntPort {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final CursoRepository cursoRepository;
    private final ModelMapper objMapper;

    public GestionarFranjaHorariaPersistImpl(FranjaHorariaRepository franjaHorariaRepository, EspacioFisicoRepository espacioFisicoRepository, CursoRepository cursoRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.cursoRepository = cursoRepository;
        this.objMapper = new ModelMapper();
    }

    @Override
    public FranjaHoraria crearFranjaHoraria(FranjaHoraria franjaHoraria) {
        FranjaHorariaEntity franjaHorariaEntity = objMapper.map(franjaHoraria, FranjaHorariaEntity.class);
        FranjaHorariaEntity franjaHorariaEntityGuardada = franjaHorariaRepository.save(franjaHorariaEntity);
        return objMapper.map(franjaHorariaEntityGuardada, FranjaHoraria.class);
    }

    @Override
    public Curso findCursoById(Integer idCurso) {
        Optional<CursoEntity> cursoEntity = cursoRepository.findById(idCurso);
        Curso curso = objMapper.map(cursoEntity.get(), Curso.class);
        return curso;
    }

    @Override
    public EspacioFisico findEspacioFisicoById(Integer idEspacioFisico) {
        Optional<EspacioFisicoEntity> espacioFisico = espacioFisicoRepository.findById(idEspacioFisico);
        EspacioFisico espacioFisicoObj = objMapper.map(espacioFisico.get(), EspacioFisico.class);
        return espacioFisicoObj;
    }

    @Override
    public List<FranjaHoraria> findByCursoId(Integer cursoId) {
        List<FranjaHorariaEntity> franjasEntities = franjaHorariaRepository.findByObjCursoId(cursoId);
        List<FranjaHoraria> franjas = this.objMapper.map(franjasEntities, new TypeToken<List<FranjaHoraria>>() {}.getType());
        return franjas;
    }
    
}
