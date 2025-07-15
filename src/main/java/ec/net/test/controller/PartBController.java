package ec.net.test.controller;

import ec.net.test.service.MoveService;
import ec.net.test.utils.LogMessage;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para exponer el api de movimientos /api/v2/move.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
@Path("/api/v2")
@ApplicationScoped
public class PartBController {

    @Inject
    MoveService moveService;

    /**
     * Metodo para enviar al cliente los movimientos
     *
     * @return respuesta al cliente
     */
    @GET
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getMoves() {
        log.info(LogMessage.INFO_LOG_START_MOVE_2.getMessage());
        return moveService.fetchMoves()
                .onItem()
                .transform(response -> Response.status(response.getHttpCode()).entity(response).build());

    }
}
