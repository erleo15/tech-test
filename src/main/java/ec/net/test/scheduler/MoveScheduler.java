package ec.net.test.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.net.test.model.dto.ProjectResponseDTO;
import ec.net.test.service.MoveService;
import ec.net.test.utils.LogMessage;
import ec.net.test.utils.ResponseCodes;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para la tarea periodica
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
@ApplicationScoped
public class MoveScheduler {

    @Inject
    MoveService moveService;

    /**
     * Metodo que se ejecuta de acuerdo al cron
     */
    @Scheduled(cron = "{part_c.schedule}")
    public void callPokeApi() {
        log.info(LogMessage.INFO_LOG_START_AUTO_TASK.getMessage());
        try {
            ProjectResponseDTO response = moveService.fetchMoves().subscribeAsCompletionStage().get();
            log.info("{}: {}", ResponseCodes.OK_RESPONSE.getMessage(), new ObjectMapper().writeValueAsString(response));
        } catch (Exception e) {
            log.error(LogMessage.ERROR_LOG_WS.getMessage());
        }
    }
}
