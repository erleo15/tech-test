package ec.net.test.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

/**
 * Interfaz para llamar a la api poke.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Path("/api/v2/move")
@RegisterRestClient(configKey = "pokeapi")
public interface PokeApiClient {

    /**
     * Metodo para consumir pokeapi
     *
     * @return retorna
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<Map<String, Object>> getMoves();
}
