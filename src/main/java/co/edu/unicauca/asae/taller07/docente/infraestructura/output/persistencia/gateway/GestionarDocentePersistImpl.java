package co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.repositorios.DocenteRepository;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepository;

@Service
public class GestionarDocentePersistImpl implements GestionarDocentePersistIntPort {

    private final DocenteRepository docenteRepository;
    private final CursoRepository cursoRepository;
    private final ModelMapper mapper;

    public GestionarDocentePersistImpl(DocenteRepository docenteRepository, CursoRepository cursoRepository, ModelMapper mapper) {
        this.docenteRepository = docenteRepository;
        this.cursoRepository = cursoRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean estaDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        return this.docenteRepository.estaDisponible(idDocente, dia, horaInicio, horaFin);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorCorreo(String correo) {
        return this.docenteRepository.existePorCorreo(correo);
    }

    @Override
    @Transactional
    public Docente guardar(Docente nuevoDocente) {
        DocenteEntity docenteEntity = this.mapper.map(nuevoDocente, DocenteEntity.class);
        DocenteEntity docenteEntityGuardado = this.docenteRepository.save(docenteEntity);
        if (docenteEntity.getCursos() != null) {
            for (CursoEntity curso : docenteEntity.getCursos()) {
                System.out.println("Curso Asignado al Docente: " + curso.getNombre());
                curso.getDocentes().add(docenteEntity);
                cursoRepository.save(curso);
            }
        }
        
        return this.mapper.map(docenteEntityGuardado, Docente.class);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existePorId(Integer idDocente) {
        return this.docenteRepository.existsById(idDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> getDocentesPorCursoId(Integer idCurso) {
        List<DocenteEntity> docentesEntities = docenteRepository.findDocentesByCursoId(idCurso);
        return this.mapper.map(docentesEntities, new TypeToken<List<Docente>>() {
        }.getType());
    }

}
