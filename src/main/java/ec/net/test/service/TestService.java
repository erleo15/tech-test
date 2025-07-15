package ec.net.test.service;

import ec.net.test.model.dto.ProjectResponseDTO;

/**
 * Interfaz para gestionar la logica de la concatenacion
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
public interface TestService {
    /**
     * Metodo para concatenar los parametros y consolidar en el objeto de respuesta al cliente.
     *
     * @param params Los parametros a concatenar.
     * @return retorna el objeto listo para responder al cliente.
     */
    public ProjectResponseDTO concatParams(String... params);
}
