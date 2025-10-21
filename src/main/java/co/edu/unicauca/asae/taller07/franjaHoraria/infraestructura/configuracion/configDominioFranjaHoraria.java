package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.docente.aplicacion.output.GestionarDocentePersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.CadenaResponsabilidadIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarCursoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarFranjaHorariaPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.DocenteDisponibleHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.EspacioFisicoActivoHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.EspacioFisicoDisponibleHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.HorarioValidoHandler;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.validaciones.chain.ValidacionHandler;

@Configuration
public class configDominioFranjaHoraria {

    @Bean
    public ValidacionHandler cadenaValidacionesFranjaHoraria(FormateadorResultadosIntPort formateadorResultados, CadenaResponsabilidadIntPort cadenaResponsabilidadesAdapter) {

        ValidacionHandler horarioValidoHandler = new HorarioValidoHandler(formateadorResultados, cadenaResponsabilidadesAdapter);
        ValidacionHandler espacioFisicoDisponibleHandler = new EspacioFisicoDisponibleHandler(formateadorResultados, cadenaResponsabilidadesAdapter);
        ValidacionHandler espacioFisicoActivoHandler = new EspacioFisicoActivoHandler(formateadorResultados,cadenaResponsabilidadesAdapter);
        ValidacionHandler docenteDisponibleHandler = new DocenteDisponibleHandler(formateadorResultados,cadenaResponsabilidadesAdapter);

        // Configurar la cadena de responsabilidad
        horarioValidoHandler.setNext(espacioFisicoDisponibleHandler);
        espacioFisicoDisponibleHandler.setNext(espacioFisicoActivoHandler);
        espacioFisicoActivoHandler.setNext(docenteDisponibleHandler);

        return horarioValidoHandler;
    }

    @Bean
    public GestionarFranjaHorariaCUAdapter gestionarFranjaHorariaCUAdapter(
        GestionarFranjaHorariaPersistIntPort gestionarFranjaHorariaPersistIntPort, 
        GestionarCursoPersistIntPort gestionarCursoPersistIntPort,
        GestionarEspacioFisicoPersistIntPort gestionarEspacioFisicoPersistIntPort,
        ValidacionHandler cadenaValidaciones, 
        FormateadorResultadosIntPort formateadorResultados,
        GestionarDocentePersistIntPort gestionarDocentePersistIntPort) {
        return new GestionarFranjaHorariaCUAdapter(
            gestionarFranjaHorariaPersistIntPort, 
            gestionarCursoPersistIntPort, 
            gestionarEspacioFisicoPersistIntPort,
            cadenaValidaciones, 
            formateadorResultados,
            gestionarDocentePersistIntPort);
    }

}
