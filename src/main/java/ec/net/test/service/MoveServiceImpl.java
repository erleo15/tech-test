package ec.net.test.service;

import ec.net.test.client.PokeApiClient;
import ec.net.test.model.dto.ProjectResponseDTO;
import ec.net.test.utils.ResponseCodes;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Duration;

/**
 * Clase para implementar los metodos para gestionar la logica de los movimientos
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Slf4j
@ApplicationScoped
public class MoveServiceImpl implements MoveService {

    @RestClient
    PokeApiClient pokeApiClient;

    @Inject
    Event<String> eventAsync;

    /**
     * Metodo para obtener los movimientos
     *
     * @return Devuelve un objeto UNI de ProjectResponseDTO
     */
    @Override
    public Uni<ProjectResponseDTO> fetchMoves() {
        return pokeApiClient.getMoves()
                .onItem().invoke(response -> eventAsync.fireAsync(response.toString()))
                .onItem().transform(response -> ProjectResponseDTO.builder()
                        .httpCode(ResponseCodes.OK_RESPONSE.getHttpStatusCode())
                        .code(ResponseCodes.OK_RESPONSE.getResponseCode())
                        .message(ResponseCodes.OK_RESPONSE.getMessage())
                        .body(response)
                        .build())
                .onFailure().retry().atMost(3)
                .ifNoItem().after(Duration.ofMillis(1500)).fail()
                .onFailure().recoverWithItem(t -> ProjectResponseDTO.builder()
                        .httpCode(ResponseCodes.ERROR_RESPONSE_SERVICE_NETWORK.getHttpStatusCode())
                        .code(ResponseCodes.ERROR_RESPONSE_SERVICE_NETWORK.getResponseCode())
                        .message(ResponseCodes.ERROR_RESPONSE_SERVICE_NETWORK.getMessage())
                        .build());
    }
}
