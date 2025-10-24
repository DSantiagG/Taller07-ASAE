package co.edu.unicauca.asae.taller07.commons.infraestructura.output.controladorExcepciones;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import co.edu.unicauca.asae.taller07.commons.infraestructura.output.controladorExcepciones.estructuraExcepciones.*;
import co.edu.unicauca.asae.taller07.commons.infraestructura.output.controladorExcepciones.estructuraExcepciones.Error;

import co.edu.unicauca.asae.taller07.commons.infraestructura.output.controladorExcepciones.excepcionesPropias.*;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestApiExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final Exception ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                                                CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                                                HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(EntidadYaExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadYaExisteException ex) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                                                String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_ACCEPTABLE.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
        }

        @ExceptionHandler(ReglaNegocioExcepcion.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final ReglaNegocioExcepcion ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(), ex.formatException(),
                                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EntidadNoExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadNoExisteException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_FOUND.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
                System.out.println("Retornando respuesta con los errores identificados");
                Map<String, String> errores = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String campo = ((FieldError) error).getField();
                        String mensajeDeError = error.getDefaultMessage();
                        errores.put(campo, mensajeDeError);
                });

                return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
                return new ResponseEntity<>(e.getMessage(),
                                HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<Map<String, Object>> handleInvalidEnumOrFormat(
                final HttpServletRequest req,
                final HttpMessageNotReadableException ex) {

                Map<String, Object> error = new HashMap<>();

                // Caso específico: Enum inválido
                if (ex.getCause() instanceof InvalidFormatException invalidEx &&
                        invalidEx.getTargetType().isEnum()) {

                        String fieldName = invalidEx.getPath().isEmpty()
                                ? "campo_desconocido"
                                : invalidEx.getPath().get(0).getFieldName();

                        error.put("campo", fieldName);
                        error.put("mensaje", "El valor proporcionado no es válido. Debe ser uno de: " +
                                Arrays.toString(invalidEx.getTargetType().getEnumConstants()));
                        error.put("codigo", HttpStatus.BAD_REQUEST.value());
                        error.put("url", req.getRequestURL().toString());
                        error.put("metodo", req.getMethod());

                        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
                }

                // Caso genérico: error de formato JSON 
                error.put("error", "Formato de datos inválido.");
                error.put("detalle", ex.getMostSpecificCause().getMessage());
                error.put("codigo", HttpStatus.BAD_REQUEST.value());
                error.put("url", req.getRequestURL().toString());
                error.put("metodo", req.getMethod());

                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
}
