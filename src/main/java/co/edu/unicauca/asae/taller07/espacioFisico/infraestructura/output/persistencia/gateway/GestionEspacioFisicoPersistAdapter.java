package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;


@Service
public class GestionEspacioFisicoPersistAdapter implements GestionarEspacioFisicoPersistIntPort{

    private final EspacioFisicoRepository objEspacioFisicoRepositorio;
    private final ModelMapper objMapeador;

    public GestionEspacioFisicoPersistAdapter(EspacioFisicoRepository objEspacioFisicoRepositorio,
            ModelMapper objMapeador) {
        this.objEspacioFisicoRepositorio = objEspacioFisicoRepositorio;
        this.objMapeador = objMapeador;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean estaDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        return this.objEspacioFisicoRepositorio.estaDisponible(idEspacio, dia, horaInicio, horaFin);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EspacioFisico> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad) {
        Iterable<EspacioFisicoEntity> lista = this.objEspacioFisicoRepositorio
                .findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre, capacidad);
        List<EspacioFisico> listaEspaciosFisicos = this.objMapeador.map(lista,
                new TypeToken<List<EspacioFisico>>() {}.getType());
        return listaEspaciosFisicos;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EspacioFisico> findAll() {
        Iterable<EspacioFisicoEntity> lista = this.objEspacioFisicoRepositorio.findAll();
        List<EspacioFisico> listaEspaciosFisicos = this.objMapeador.map(lista, new TypeToken<List<EspacioFisico>>() {
        }.getType());
        return listaEspaciosFisicos;
    }

    @Transactional
    @Override
    public int actualizarEstado(Integer idEspacio, Boolean nuevoEstado) {
        return this.objEspacioFisicoRepositorio.actualizarEstado(idEspacio, nuevoEstado);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean existsById(Integer idEspacio) {
        return this.objEspacioFisicoRepositorio.existsById(idEspacio);
    }

    @Transactional(readOnly = true)
    @Override
    public EspacioFisico obtenerEspacioFisicoById(Integer idEspacio) {
        if (this.objEspacioFisicoRepositorio.existsById(idEspacio)) {
            EspacioFisicoEntity espacioFisicoEntity = this.objEspacioFisicoRepositorio.findById(idEspacio).get();
            EspacioFisico espacioFisico = this.objMapeador.map(espacioFisicoEntity, EspacioFisico.class);
            return espacioFisico;
        }
        return null;
    }
}