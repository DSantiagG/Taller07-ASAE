package co.edu.unicauca.asae.taller07.espacioFisico.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller07.commons.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.input.GestionarEspacioFisicoCUIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.aplicacion.output.GestionarEspacioFisicoPersistIntPort;
import co.edu.unicauca.asae.taller07.espacioFisico.dominio.modelos.EspacioFisico;

public class GestionarEspacioFisicoCUAdapter implements GestionarEspacioFisicoCUIntPort {

    private final GestionarEspacioFisicoPersistIntPort objGestionarEspacioFisicoPersist;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarEspacioFisicoCUAdapter(GestionarEspacioFisicoPersistIntPort objGestionarEspacioFisicoPersist, FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionarEspacioFisicoPersist = objGestionarEspacioFisicoPersist;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<EspacioFisico> findByNombreAndCapacidadGreaterThanEqual(String nombre, Integer capacidad) {
        List<EspacioFisico> listaObtenida = objGestionarEspacioFisicoPersist.findByNombreAndCapacidadGreaterThanEqual(nombre, capacidad);
        return listaObtenida;
    }

    @Override
    public int actualizarEstado(Integer idEspacio, Boolean nuevoEstado) {
        if (!objGestionarEspacioFisicoPersist.existsById(idEspacio)) {
            this.objFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("Error, el espacio físico con id " + idEspacio + " no existe.");
        }
        int filasAfectadas = objGestionarEspacioFisicoPersist.actualizarEstado(idEspacio, nuevoEstado);
        return filasAfectadas;
    }

    @Override
    public List<EspacioFisico> findAll() {
        List<EspacioFisico> listaObtenida = objGestionarEspacioFisicoPersist.findAll();
        return listaObtenida;
    }
}
