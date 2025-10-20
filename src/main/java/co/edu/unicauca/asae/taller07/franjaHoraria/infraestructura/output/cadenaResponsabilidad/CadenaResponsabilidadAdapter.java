package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.cadenaResponsabilidad;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller07.commons.dominio.modelos.EnumDias;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.repositorios.DocenteRepository;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.entidades.EspacioFisicoEntity;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.CadenaResponsabilidadIntPort;

@Service
public class CadenaResponsabilidadAdapter implements CadenaResponsabilidadIntPort {

    private final EspacioFisicoRepository espacioFisicoRepository;
    private final DocenteRepository docenteRepository;
    private final ModelMapper mapper;

    public CadenaResponsabilidadAdapter(EspacioFisicoRepository espacioFisicoRepository, DocenteRepository docenteRepository, ModelMapper mapper) {
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.docenteRepository = docenteRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean estaEspacioFisicoDisponible(Integer idEspacio, EnumDias dia, LocalTime horaInicio,
            LocalTime horaFin) {
        return espacioFisicoRepository.estaDisponible(idEspacio, dia, horaInicio, horaFin);
    }

    @Override
    public boolean estaDocenteDisponible(Integer idDocente, EnumDias dia, LocalTime horaInicio, LocalTime horaFin) {
        return docenteRepository.estaDisponible(idDocente, dia, horaInicio, horaFin);
    }

    @Override
    public EspacioFisico obtenerEspacioFisicoById(Integer idEspacio) {
        EspacioFisicoEntity espacioEntity = espacioFisicoRepository.findById(idEspacio).orElse(null);
        if (espacioEntity != null) {
            return mapper.map(espacioEntity, EspacioFisico.class);
        }

        return null;
    }



}
