package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.docente.infraestructura.output.persistencia.repositorios.DocenteRepository;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.output.persistencia.repositorios.EspacioFisicoRepository;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.DocenteDisponibleHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.EspacioFisicoActivoHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.EspacioFisicoDisponibleHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.HorarioValidoHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.ValidacionHandler;

@Configuration
public class configDominioFranjaHoraria {

    @Bean
    public ValidacionHandler cadenaValidacionesFranjaHoraria(FormateadorResultadosIntPort formateadorResultados, DocenteRepository docenteRepository, EspacioFisicoRepository espacioFisicoRepository) {

        ValidacionHandler horarioValidoHandler = new HorarioValidoHandler(formateadorResultados);
        ValidacionHandler espacioFisicoDisponibleHandler = new EspacioFisicoDisponibleHandler(espacioFisicoRepository, formateadorResultados);
        ValidacionHandler espacioFisicoActivoHandler = new EspacioFisicoActivoHandler(espacioFisicoRepository, formateadorResultados);
        ValidacionHandler docenteDisponibleHandler = new DocenteDisponibleHandler(docenteRepository, espacioFisicoRepository, formateadorResultados);

        // Configurar la cadena de responsabilidad
        horarioValidoHandler.setNext(espacioFisicoDisponibleHandler);
        espacioFisicoDisponibleHandler.setNext(espacioFisicoActivoHandler);
        espacioFisicoActivoHandler.setNext(docenteDisponibleHandler);

        return horarioValidoHandler;
    }

    @Bean
    public GestionarFranjaHorariaCUAdapter gestionarFranjaHorariaCUAdapter(ValidacionHandler cadenaValidaciones) {
        return new GestionarFranjaHorariaCUAdapter(cadenaValidaciones);
    }

}
