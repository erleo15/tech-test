package ec.net.test.service;

import ec.net.test.model.dto.ProjectResponseDTO;
import io.smallrye.mutiny.Uni;

/**
 * Interfaz para gestionar la logica de los movimientos
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
public interface MoveService {
    /**
     * Metodo para obtener los movimientos
     *
     * @return Devuelve un objeto UNI de ProjectResponseDTO
     */
    Uni<ProjectResponseDTO> fetchMoves();
}
