package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller07.franjaHoraria.aplicacion.input.GestionarFranjaHorariaCUIntPort;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTOPeticion.FranjaHorariaDTOPeticion;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeCursoDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.DTORespuesta.FranjaHorariaDeDocenteDTORespuesta;
import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.input.controllerGestionarFranjaHoraria.mappers.FranjaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/franja-horaria")
@RequiredArgsConstructor
public class FranjaHorariaRestController {

    private final GestionarFranjaHorariaCUIntPort objGestionarFranjaHorariaCUInt;
    private final FranjaMapperInfraestructuraDominio objMapeador;

    @PostMapping()
    public ResponseEntity<FranjaHorariaDeDocenteDTORespuesta> crearFranjaHoraria(@RequestBody FranjaHorariaDTOPeticion franjaHorariaDTOPeticion) {
        Integer idCurso = franjaHorariaDTOPeticion.getIdCurso();
        Integer idEspacioFisico = franjaHorariaDTOPeticion.getIdEspacioFisico();
        FranjaHoraria franjaHorariaDominio = objMapeador.mappearDePeticionAFranjaHoraria(franjaHorariaDTOPeticion);
        FranjaHoraria franjaHorariaCreada = this.objGestionarFranjaHorariaCUInt.crearFranjaHoraria(franjaHorariaDominio, idCurso, idEspacioFisico);
        ResponseEntity<FranjaHorariaDeDocenteDTORespuesta> objRespuesta = new ResponseEntity<>(objMapeador.mappearDeFranjaHorariaDeDocenteARespuesta(franjaHorariaCreada),HttpStatus.CREATED);
        return objRespuesta;
    }

    //TODO: CAMBIAR A EAGER
    @GetMapping("/ByDocente/{idDocente}")
    public ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> listarFranjaHorariaPorDocente(@PathVariable Integer idDocente) {
        List<FranjaHoraria> listaFranjas = this.objGestionarFranjaHorariaCUInt.findByDocenteId(idDocente);
        List<FranjaHorariaDeDocenteDTORespuesta> listaFranjasDTO = objMapeador.mappearDeListaFranjaHorariaDeDocenteARespuesta(listaFranjas);
        ResponseEntity<List<FranjaHorariaDeDocenteDTORespuesta>> objRespuesta = new ResponseEntity<>(listaFranjasDTO, HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/ByCurso/{idCurso}")
    public ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> listarFranjaHorariaPorCurso(@PathVariable Integer idCurso) {
        List<FranjaHoraria> listaFranjas = this.objGestionarFranjaHorariaCUInt.findByCursoId(idCurso);
        List<FranjaHorariaDeCursoDTORespuesta> listaFranjasDTO = objMapeador.mappearDeFranjaHorariaDeCursoARespuesta(listaFranjas);
        ResponseEntity<List<FranjaHorariaDeCursoDTORespuesta>> objRespuesta = new ResponseEntity<>(listaFranjasDTO, HttpStatus.OK);
        return objRespuesta;
    }

    @DeleteMapping("/ByCurso/{idCurso}")
    public ResponseEntity<Void> eliminarFranjasPorCurso(@PathVariable Integer idCurso) {
        this.objGestionarFranjaHorariaCUInt.eliminarFranjasPorCurso(idCurso);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
