package ec.net.test.interceptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.net.test.utils.LogMessage;
import io.smallrye.common.annotation.Blocking;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Clase para filtrar las tramas de ingreso
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Provider
@Data
@Slf4j
@Blocking
public class AccessFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS);

    /**
     * Metodo para filtrar los request.
     *
     * @param requestContext Contexto de request.
     */
    @Override
    public void filter(ContainerRequestContext requestContext) {
        filterRequest(requestContext);
    }

    /**
     * Metodo para realizar log de request al microservicio.
     *
     * @param requestContext Parametro de contexto.
     */
    @SneakyThrows
    public void filterRequest(ContainerRequestContext requestContext) {
        log.info(LogMessage.INFO_LOG_HEADERS_DETAIL.getMessage(), mapper.writeValueAsString((requestContext.getHeaders())));
        log.info(LogMessage.INFO_LOG_QUERY_PARAM_DETAIL.getMessage(), mapper.writeValueAsString((requestContext.getUriInfo().getQueryParameters())));
        InputStream is = requestContext.getEntityStream();
        try {
            String body = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
            log.info(LogMessage.INFO_LOG_BODY_DETAIL.getMessage(), body);
            requestContext.setEntityStream(new ByteArrayInputStream((body).getBytes()));
        } catch (Exception e) {

        }
    }

    /**
     * Metodo para realizar logs de salida
     *
     * @param containerRequestContext  data ingreso
     * @param containerResponseContext data salida
     */
    @SneakyThrows
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) {
        log.info(LogMessage.INFO_LOG_EXIT_DATA_DETAIL.getMessage(), containerRequestContext.getUriInfo().getRequestUri(),
                containerResponseContext.getStatus(),
                mapper.writeValueAsString(containerResponseContext.getHeaders()),
                mapper.writeValueAsString(containerResponseContext.getEntity()));
    }
}