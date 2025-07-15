package ec.net.test.service;

import ec.net.test.model.dto.ProjectResponseDTO;
import ec.net.test.utils.HandleString;
import ec.net.test.utils.LogMessage;
import ec.net.test.utils.ResponseCodes;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Clase para implementar los metodos que permitiran gestionar la logica de la concatenacion
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@ApplicationScoped
@Slf4j
public class TestServiceImpl implements TestService {

    /**
     * Metodo para concatenar los parametros y consolidar en el objeto de respuesta al cliente.
     *
     * @param params Los parametros a concatenar.
     * @return retorna el objeto listo para responder al cliente.
     */
    @Override
    public ProjectResponseDTO concatParams(String... params) {
        if (HandleString.verifyNullEmpty(params)) {
            log.error(LogMessage.ERROR_LOG_EMPTY_NULL.getMessage());
            return ProjectResponseDTO.builder().httpCode(ResponseCodes.ERROR_RESPONSE_EMPTY_OR_NULL.getHttpStatusCode())
                    .code(ResponseCodes.ERROR_RESPONSE_EMPTY_OR_NULL.getResponseCode())
                    .message(ResponseCodes.ERROR_RESPONSE_EMPTY_OR_NULL.getMessage()).build();
        }
        if (HandleString.verifySQLINJ(params)) {
            log.error(LogMessage.ERROR_LOG_SQL_INJ.getMessage());
            return ProjectResponseDTO.builder().httpCode(ResponseCodes.ERROR_RESPONSE_SQL_INJ.getHttpStatusCode())
                    .code(ResponseCodes.ERROR_RESPONSE_SQL_INJ.getResponseCode())
                    .message(ResponseCodes.ERROR_RESPONSE_SQL_INJ.getMessage()).build();
        }
        log.info(LogMessage.OK_LOG.getMessage());
        return ProjectResponseDTO.builder().httpCode(ResponseCodes.OK_RESPONSE.getHttpStatusCode())
                .code(ResponseCodes.OK_RESPONSE.getResponseCode()).message(ResponseCodes.OK_RESPONSE.getMessage())
                .body(Map.of("concatenated", concatenateStrings(params)))
                .build();
    }

    private String concatenateStrings(String... values) {
        return String.join(" ", values);
    }
}
