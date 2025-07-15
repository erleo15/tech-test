package ec.net.test.controller;

import ec.net.test.model.dto.ProjectResponseDTO;
import ec.net.test.service.TestService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Clase para implementar la primera parte de la prueba, concatenacion de parametros.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@RequestScoped
@Path("/api/v1")
public class PartAController {
    @Inject
    TestService testService;
    @Inject
    Event<String> eventBus; // EventBus bloqueante

    /**
     * Metodo para declarar el API /api/v1/test
     *
     * @param param1 Primer parametro en el request
     * @param param2 Segundo parametro en el request
     * @param param3 Tercer parametro en el request
     * @param param4 Cuarto parametro en el request
     * @param param5 Quinto parametro en el request
     * @return Respuesta al cliente
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/test")
    public Response doConcatParams(@QueryParam("param1") String param1,
                                   @QueryParam("param2") String param2,
                                   @QueryParam("param3") String param3,
                                   @QueryParam("param4") String param4,
                                   @QueryParam("param5") String param5) {
        ProjectResponseDTO projectResponseDTO = testService.concatParams(param1, param2, param3, param4, param5);
        eventBus.fire(projectResponseDTO.toString());
        return Response.status(projectResponseDTO.getHttpCode())
                .entity(projectResponseDTO)
                .build();
    }
}
