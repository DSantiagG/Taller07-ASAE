package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarCursoCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.DTORespuesta.CursoDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarCurso.mappers.CursoMapperInfraestructuraDominio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
@Validated
public class CursoRestController {
    
    private final GestionarCursoCUIntPort objGestionarCursoCUIntPort;
    private final CursoMapperInfraestructuraDominio objMapeador;

    @GetMapping("/buscar")
    public ResponseEntity<List<CursoDTORespuesta>> buscarPorNombreAsignatura(
            @RequestParam("nombreAsignatura") @NotBlank String nombreAsignatura) {
        ResponseEntity<List<CursoDTORespuesta>> objRespuesta = new ResponseEntity<List<CursoDTORespuesta>>(
                objMapeador.mappearDeCursosARespuesta(
                        this.objGestionarCursoCUIntPort.findByAsignaturaNombre(nombreAsignatura)),
                HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoDTORespuesta> obtenerCursoPorId(
            @PathVariable("idCurso") @Positive Integer idCurso) {
        ResponseEntity<CursoDTORespuesta> objRespuesta = new ResponseEntity<CursoDTORespuesta>(
                objMapeador.mappearDeCursoARespuesta(
                        this.objGestionarCursoCUIntPort.obtenerCursoById(idCurso)),
                HttpStatus.OK);
        return objRespuesta;
    }
}