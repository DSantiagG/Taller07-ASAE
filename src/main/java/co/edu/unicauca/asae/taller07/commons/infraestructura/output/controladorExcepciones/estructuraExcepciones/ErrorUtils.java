package co.edu.unicauca.asae.taller07.commons.infraestructura.output.controladorExcepciones.estructuraExcepciones;

public final class ErrorUtils {

  ErrorUtils() {

  }

  /**
   * Crea un nuevo objeto de <code>Error</code>
   * 
   * @param codigoError
   * @param llaveMensaje
   * @param codigoHttp
   * @return - Objeto creado
   */
  public static Error crearError(final String codigoError, final String llaveMensaje, final Integer codigoHttp) {
    final Error error = new Error();
    error.setCodigoError(codigoError);
    error.setMensaje(llaveMensaje);
    error.setCodigoHttp(codigoHttp);
    return error;
  }
}
