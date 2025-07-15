package ec.net.test.event;

import ec.net.test.utils.LogMessage;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para escuchar el evento no bloqueante
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
@ApplicationScoped
public class EvenNonBlockingListener {

    /**
     * Metodo para dar tratamiento al evento no bloqueante
     *
     * @param eventPayload mensaje recibido
     */
    @SneakyThrows
    public void onNonBlocking(@ObservesAsync String eventPayload) {
        Thread.sleep(3000);
        log.info(LogMessage.INFO_LOG_NON_BLOCKING_DETAIL.getMessage(), eventPayload);
    }
}