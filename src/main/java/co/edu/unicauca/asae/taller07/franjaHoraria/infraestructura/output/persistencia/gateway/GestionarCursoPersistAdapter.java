package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarCursoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.CursoEntity;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios.CursoRepository;

@Service
public class GestionarCursoPersistAdapter implements GestionarCursoPersistIntPort {

    private final CursoRepository objCursoRepositorio;
    private final ModelMapper objMapeador;

    public GestionarCursoPersistAdapter(CursoRepository objCursoRepositorio, ModelMapper objMapeador) {
        this.objCursoRepositorio = objCursoRepositorio;
        this.objMapeador = objMapeador;
    }

    @Override
    public List<Curso> findByAsignaturaNombre(String nombreAsignatura) {
        List<CursoEntity> lista = this.objCursoRepositorio.findByObjAsignaturaNombre(nombreAsignatura);
        List<Curso> listaCursos = this.objMapeador.map(lista, new TypeToken<List<Curso>>() {}.getType());
        return listaCursos;
    }

    @Override
    public Curso obtenerCursoById(Integer idCurso) {
        if (this.objCursoRepositorio.existsById(idCurso) == false) {
            return null; 
        }
        CursoEntity cursoEntity = this.objCursoRepositorio.obtenerCursoById(idCurso);
        Curso curso = this.objMapeador.map(cursoEntity, Curso.class);
        return curso;
    }

    @Override
    public boolean existsById(Integer idCurso) {
        return this.objCursoRepositorio.existsById(idCurso);
    }
}
