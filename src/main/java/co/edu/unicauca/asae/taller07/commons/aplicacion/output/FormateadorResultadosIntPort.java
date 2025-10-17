package co.edu.unicauca.asae.taller07.commons.aplicacion.output;

public interface FormateadorResultadosIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje);
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
