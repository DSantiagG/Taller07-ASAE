package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.validaciones;

import org.springframework.stereotype.Component;

import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;
import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.output.GestionarCursoPersistIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion.FranjaHorariaDTOPeticion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class CapacidadValidaValidator implements ConstraintValidator<CapacidadValida, FranjaHorariaDTOPeticion> {

    private final GestionarCursoPersistIntPort gestionarCursoCUIntPort;
    private final GestionarEspacioFisicoPersistIntPort gestionarEspacioFisicoCUIntPort;

    public CapacidadValidaValidator(GestionarCursoPersistIntPort gestionarCursoCUIntPort,
            GestionarEspacioFisicoPersistIntPort gestionarEspacioFisicoCUIntPort) {
        this.gestionarCursoCUIntPort = gestionarCursoCUIntPort;
        this.gestionarEspacioFisicoCUIntPort = gestionarEspacioFisicoCUIntPort;
    }

    @Override
    public boolean isValid(FranjaHorariaDTOPeticion franjaHorariaDTO, ConstraintValidatorContext context) {
        
        if(franjaHorariaDTO.getIdCurso() == null || franjaHorariaDTO.getIdEspacioFisico() == null) {
            return true; // La validación de null se maneja con @NotNull
        }
        Curso curso = gestionarCursoCUIntPort.obtenerCursoById(franjaHorariaDTO.getIdCurso());
        EspacioFisico espacioFisico = gestionarEspacioFisicoCUIntPort.obtenerEspacioFisicoById(franjaHorariaDTO.getIdEspacioFisico());

        if(curso == null || espacioFisico == null) {
            return true; // La validación de existencia no se maneja aquí
        }

        boolean esValida = espacioFisico.getCapacidad() >= curso.getCupo();

        if (!esValida) {
            // Deshabilitar el mensaje de error por defecto
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{franjaHoraria.capacidad.invalida}")
                    .addPropertyNode("idEspacioFisico") // campo al que se asocia el error
                    .addConstraintViolation();
        }

        return esValida;
    }
    
}
