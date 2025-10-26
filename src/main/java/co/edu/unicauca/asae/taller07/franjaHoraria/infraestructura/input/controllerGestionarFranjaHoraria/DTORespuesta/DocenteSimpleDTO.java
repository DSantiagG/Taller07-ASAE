package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta;

import lombok.Data;

@Data
public class DocenteSimpleDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String identificacion;
}
