package ec.net.test.utils;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase para gestionar los codigos y mensajes de respuesta.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Getter
@AllArgsConstructor
public enum ResponseCodes {

    OK_RESPONSE("000", "Operacion correcta", Response.Status.OK.getStatusCode()),
    ERROR_RESPONSE_EMPTY_OR_NULL("0001", "Hay valores en vacio o en null.", Response.Status.BAD_REQUEST.getStatusCode()),
    ERROR_RESPONSE_SQL_INJ("0002", "Alerta! Posible intento de SQL INJECTION.", Response.Status.BAD_REQUEST.getStatusCode()),
    ERROR_RESPONSE_SERVICE_FALLBACK("0020", "Error! El servicio esta no esta disponible.", Response.Status.SERVICE_UNAVAILABLE.getStatusCode()),
    ERROR_RESPONSE_UNKNOWN_ERROR("0030", "Error! Ocurrio un error desconocido, intentelo nuevamente.", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()),
    ERROR_RESPONSE_SERVICE_NETWORK("0010", "Alerta! No fue posible conectar al servicio externo.", Response.Status.SERVICE_UNAVAILABLE.getStatusCode()),
    ;

    private final String responseCode;
    private final String message;
    private final int httpStatusCode;
}
