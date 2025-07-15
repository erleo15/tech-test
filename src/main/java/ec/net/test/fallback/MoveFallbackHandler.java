package ec.net.test.fallback;

import ec.net.test.model.dto.ProjectResponseDTO;
import ec.net.test.utils.LogMessage;
import ec.net.test.utils.ResponseCodes;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

/**
 * Clase para gestionar el la respuesta de respaldo
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
@ApplicationScoped
public class MoveFallbackHandler implements FallbackHandler<ProjectResponseDTO> {
    /**
     * Metodo para la logica del gestor.
     *
     * @param executionContext Contexto recibido.
     * @return Retorna una respuesta.
     */
    @Override
    public ProjectResponseDTO handle(ExecutionContext executionContext) {
        log.error(LogMessage.ERROR_LOG_BACKUP_FALL.getMessage());
        return ProjectResponseDTO.builder().httpCode(ResponseCodes.ERROR_RESPONSE_SERVICE_FALLBACK.getHttpStatusCode())
                .code(ResponseCodes.ERROR_RESPONSE_SERVICE_FALLBACK.getResponseCode())
                .message(ResponseCodes.ERROR_RESPONSE_SERVICE_FALLBACK.getMessage())
                .build();
    }
}

