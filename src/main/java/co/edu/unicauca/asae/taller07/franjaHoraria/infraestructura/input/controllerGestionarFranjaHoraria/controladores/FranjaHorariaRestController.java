package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers.FranjaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/franja-horaria")
@RequiredArgsConstructor
public class FranjaHorariaRestController {

    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
    private final FranjaMapperInfraestructuraDominio objMapeador;

    public ResponseEntity<FranjaHorariaDTORespuesta> crearFranjaHoraria(FranjaHorariaDTOPeticion franjaHorariaDTOPeticion) {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseEntity<List<FranjaHorariaDTORespuesta>> listarFranjaHorariaPorDocente(Integer idDocente) {
        // TODO Auto-generated method stub
        return null;
    }

    public ResponseEntity<List<FranjaHorariaDTORespuesta>> listarFranjaHorariaPorCurso(Integer idCurso) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
