package ec.net.test.interceptor;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.ext.Provider;

/**
 * Clase para propagacion de headers
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class HeaderPropagator implements ClientRequestFilter {

    @Context
    HttpHeaders headers;

    /**
     * Metodo para propagar los headers.
     *
     * @param requestContext Contexto en donde se propagara.
     */
    @Override
    public void filter(ClientRequestContext requestContext) {
        try {
            headers.getRequestHeaders().forEach((key, values) -> {
                if (key.equalsIgnoreCase("X-Correlation-ID")) {
                    for (String value : values) {
                        requestContext.getHeaders().add(key, value);
                    }
                }
            });
        } catch (IllegalStateException ignored) {

        }
    }
}

