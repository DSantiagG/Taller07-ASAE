package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.validaciones;

import java.time.LocalTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FormatoMilitarValidator implements ConstraintValidator<FormatoMilitar, LocalTime> { // Implementa la lógica de validación para la anotación @FormatoMilitar

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // La validación de null se maneja con @NotNull
        }
        int hour = value.getHour();
        int minute = value.getMinute();
        return (hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59);
    }

}