package ec.net.test.event;

import ec.net.test.utils.LogMessage;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para escuchar el evento bloqueante
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
@ApplicationScoped
public class BlockEventListener {

    /**
     * Metodo para dar tratamiento al evento recibido
     *
     * @param message Mensaje recibido
     */
    @SneakyThrows
    public void onConcatenation(@Observes String message) {
        log.info(LogMessage.INFO_LOG_BLOCKING_DETAIL.getMessage(), message);//tratamiento al mensaje del evento
        Thread.sleep(2000);//dormir el hilo por 1 segundo para simular alguna tarea interna
    }
}

