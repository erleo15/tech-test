package ec.net.test.config;

import ec.net.test.utils.LogMessage;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * Clase para implementar la configuracion inicial del microservicio.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
public class AppConfig {

    @ConfigProperty(name = "alert.file.injected", defaultValue = "Alerta, no recuperado!")
    String propertyInject;

    /**
     * Metodo que se ejecuta al arrancar l microservicio por una sola vez
     *
     * @param ev listener
     */
    void onStart(@Observes StartupEvent ev) {
        log.info(LogMessage.INFO_LOG_ALERT_PROPERTIES.getMessage(), propertyInject);
    }
}
