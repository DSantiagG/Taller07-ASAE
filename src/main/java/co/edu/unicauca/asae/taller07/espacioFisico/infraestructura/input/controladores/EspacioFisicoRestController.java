package co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.DTORespuesta.EspacioFisicoDTORespuesta;
import co.edu.unicauca.asae.taller07.espacioFisico.infraestructura.input.mappers.EspacioFisicoMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@RestController
@RequestMapping("/api/espacios-fisicos")
@RequiredArgsConstructor
@Validated
public class EspacioFisicoRestController {
    private final GestionarEspacioFisicoCUIntPort objGestionarEspacioFisicoCUIntPort;
    private final EspacioFisicoMapperInfraestructuraDominio objMapeador;

    @GetMapping()
    public ResponseEntity<List<EspacioFisicoDTORespuesta>> listarEspaciosFisicos() {
        ResponseEntity<List<EspacioFisicoDTORespuesta>> objRespuesta = new ResponseEntity<List<EspacioFisicoDTORespuesta>>(
                objMapeador.mappearDeEspaciosFisicosAEspacioFisicoDTORespuesta(
                        this.objGestionarEspacioFisicoCUIntPort.findAll()),
                HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EspacioFisicoDTORespuesta>> buscarPorNombreYCapacidad(
            @RequestParam("nombre") @NotBlank String nombre,
            @RequestParam("capacidad") @NotNull @Min(1) Integer capacidad) {
        ResponseEntity<List<EspacioFisicoDTORespuesta>>  objRespuesta = new ResponseEntity<List<EspacioFisicoDTORespuesta>>(
                objMapeador.mappearDeEspaciosFisicosAEspacioFisicoDTORespuesta(
                        this.objGestionarEspacioFisicoCUIntPort.findByNombreAndCapacidadGreaterThanEqual(nombre, capacidad)),
                HttpStatus.OK);
        return objRespuesta;
    }

    @PatchMapping("/{idEspacio}/estado")
    public ResponseEntity<Void> actualizarEstado(
            @PathVariable("idEspacio") @Positive Integer idEspacio,
            @RequestParam("nuevoEstado") @NotNull Boolean nuevoEstado) {
        this.objGestionarEspacioFisicoCUIntPort.actualizarEstado(idEspacio, nuevoEstado);
        return ResponseEntity.noContent().build();
    }
}