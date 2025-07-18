package ec.net.test.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Clase para gestionar los mensajes de LOGS.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Getter
@AllArgsConstructor
public enum LogMessage {

    OK_LOG("PROCESO COMPLETADO"),
    INFO_LOG_ALERT_PROPERTIES("ALERTA DE PROPERTIES: {} "),
    INFO_LOG_START_MOVE_2("CONSULTANDO MOVES"),
    INFO_LOG_START_CONSuME_EXTERNAL_WS("CONSUMIENDO SERVICIO EXTERNO"),
    INFO_LOG_START_AUTO_TASK("Ejecutando tarea automatica para consumir a PokeAPI..."),
    ERROR_LOG_EMPTY_NULL("VALORES NULL O VACIOS, VERIFIQUE EL INGRESO"),
    ERROR_LOG_SQL_INJ("VALORES PODRIAN TRATARSE DE UN SQL INJECTION, VERIFIQUE LA ENTRADA"),
    ERROR_LOG_BACKUP_FALL("USANDO RESPUESTA BACKUP, ANTERIOR NO FUNCIONA."),
    ERROR_LOG_FAIL_NETWORK("ERROR EN LA RED, VERIFIQUE SUS CONFIGURACIONES DE RED O PROPIEDADES DE CONEXION."),
    ERROR_LOG_UNKNOWN("ERROR DESCONOCIDO, StackTrace:{}"),
    INFO_LOG_ENDPOINT_DETAIL("WS_URL={}; MethodInput={}; MediaTypeIn={}"),
    INFO_LOG_HEADERS_DETAIL("MOSTRANDO LOS HEADERS DE ENTRADA: {}"),
    INFO_LOG_QUERY_PARAM_DETAIL("MOSTRANDO LOS QUERY PARAM DE ENTRADA: {}"),
    INFO_LOG_EXIT_DATA_DETAIL("MOSTRANDO DATA DE SALIDA DE WS={}, httpCode={}, headers={}, body:{}"),
    INFO_LOG_BODY_DETAIL("MOSTRANDO BODY/DATA: {}"),
    INFO_LOG_BLOCKING_DETAIL("EVENTO BLOQUEANTE RECIBIDO: {}"),
    INFO_LOG_NON_BLOCKING_DETAIL("EVENTO NO BLOQUEANTE RECIBIDO: {}"),
    ERROR_LOG_WS("NO SE PUDO EJECUTAR LA LLAMADA AL WS"),
    ;

    private final String message;
}
