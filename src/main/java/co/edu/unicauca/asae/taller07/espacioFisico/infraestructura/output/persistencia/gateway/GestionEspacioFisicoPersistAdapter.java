package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.gateway;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import jakarta.transaction.Transactional;

@Service
public class GestionEspacioFisicoPersistAdapter implements GestionarEspacioFisicoPersistIntPort{

    private final EspacioFisicoRepository objEspacioFisicoRepositorio;
    private final ModelMapper objMapeador;

    public GestionEspacioFisicoPersistAdapter(EspacioFisicoRepository objEspacioFisicoRepositorio,
            ModelMapper objMapeador) {
        this.objEspacioFisicoRepositorio = objEspacioFisicoRepositorio;
        this.objMapeador = objMapeador;
    }

    @Override
    public boolean estaDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        return this.objEspacioFisicoRepositorio.estaDisponible(idEspacio, dia, horaInicio, horaFin);
    }

    @Override
    public List<EspacioFisico> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad) {
        Iterable<EspacioFisicoEntity> lista = this.objEspacioFisicoRepositorio
                .findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombreAsc(nombre, capacidad);
        List<EspacioFisico> listaEspaciosFisicos = this.objMapeador.map(lista,
                new TypeToken<List<EspacioFisico>>() {}.getType());
        return listaEspaciosFisicos;
    }

    @Override
    public List<EspacioFisico> findAll() {
        Iterable<EspacioFisicoEntity> lista = this.objEspacioFisicoRepositorio.findAll();
        List<EspacioFisico> listaEspaciosFisicos = this.objMapeador.map(lista, new TypeToken<List<EspacioFisico>>() {
        }.getType());
        return listaEspaciosFisicos;
    }

    @Override
    @Transactional
    public int actualizarEstado(Integer idEspacio, Boolean nuevoEstado) {
        return this.objEspacioFisicoRepositorio.actualizarEstado(idEspacio, nuevoEstado);
    }

    @Override
    public Boolean existsById(Integer idEspacio) {
        return this.objEspacioFisicoRepositorio.existsById(idEspacio);
    }
}