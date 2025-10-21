package co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.entidades.OficinaEntity;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.repositorios.DocenteRepository;

@Service
public class GestionarDocentePersistImpl implements GestionarDocentePersistIntPort {

    private final DocenteRepository docenteRepository;
    private final ModelMapper mapper;

    public GestionarDocentePersistImpl(DocenteRepository docenteRepository, ModelMapper mapper) {
        this.docenteRepository = docenteRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean estaDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        return this.docenteRepository.estaDisponible(idDocente, dia, horaInicio, horaFin);
    }


    @Override
    public boolean existePorCorreo(String correo) {
        return this.docenteRepository.existePorCorreo(correo);
    }


    @Override
    public Docente guardar(Docente nuevoDocente) {
        DocenteEntity docenteEntity = this.mapper.map(nuevoDocente, DocenteEntity.class);
        DocenteEntity docenteEntityGuardado = this.docenteRepository.save(docenteEntity);
        return this.mapper.map(docenteEntityGuardado, Docente.class);
    }

    @Override
    public boolean existePorId(Integer idDocente) {
        return this.docenteRepository.existsById(idDocente);
    }

    //TODO
    @Override
    public List<Docente> getDocentesPorCursoId(Integer idCurso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDocentesPorCursoId'");
    }

}
