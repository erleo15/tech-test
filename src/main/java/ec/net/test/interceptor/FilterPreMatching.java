package ec.net.test.interceptor;

import ec.net.test.utils.LogMessage;
import io.smallrye.common.annotation.Blocking;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * Clase para filtrar el ingreso en una fase anterior
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Provider
@Data
@PreMatching
@Slf4j
@Blocking
public class FilterPreMatching implements ContainerRequestFilter {

    /**
     * Metodo para filtrar los request.
     *
     * @param requestContext Contexto de request.
     */
    @Override
    public void filter(ContainerRequestContext requestContext) {
        log.info(LogMessage.INFO_LOG_ENDPOINT_DETAIL.getMessage(), requestContext.getUriInfo().getAbsolutePath(), requestContext.getMethod(), requestContext.getMediaType());
        requestContext.setMethod(requestContext.getMethod().toUpperCase());
    }
}