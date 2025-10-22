package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.validaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented // Indica que esta anotación aparece en la documentación Javadoc
@Constraint(validatedBy = FormatoMilitarValidator.class) // Especifica la clase que implementa la lógica de validación
@Target({ElementType.FIELD}) // Indica que esta anotación se puede aplicar a campos
@Retention(RetentionPolicy.RUNTIME) // La anotación estará disponible en tiempo de ejecución
public @interface FormatoMilitar { //@ indica que es una anotación personalizada
    String message() default "{franjaHoraria.horaInicio.formatoMilitar}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
