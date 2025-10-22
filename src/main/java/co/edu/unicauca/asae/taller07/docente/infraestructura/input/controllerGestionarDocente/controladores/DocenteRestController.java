package co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.controladores;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller07.docente.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller07.docente.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller07.docente.infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller07.franjaHoraria.dominio.modelos.Curso;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/docente")
@RequiredArgsConstructor
public class DocenteRestController {

    private final GestionarDocenteCUIntPort gestionarDocenteCU;
    private final DocenteMapperInfraestructuraDominio docenteMapper;

    @PostMapping
    public ResponseEntity<DocenteDTORespuesta> crearDocente(@RequestBody @Valid DocenteDTOPeticion docenteDto) {
        Docente docenteDominio = docenteMapper.aDominio(docenteDto);
        docenteDominio.setCursos(new ArrayList<>());
        for(Integer idCurso:docenteDto.getCursos()){
            docenteDominio.getCursos().add(new Curso(idCurso));
        }
        Docente docenteCreado = gestionarDocenteCU.crearDocente(docenteDominio);
        ResponseEntity<DocenteDTORespuesta> objRespuesta =new ResponseEntity<>(docenteMapper.aDtoRespuesta(docenteCreado),HttpStatus.CREATED);

        return objRespuesta;
    }
    


}
