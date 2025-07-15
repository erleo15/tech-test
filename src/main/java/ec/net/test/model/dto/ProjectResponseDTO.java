package ec.net.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Clase para manejar la respuesta al cliente.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {
    private int httpCode;
    private String code;
    private String message;
    private Map<String, Object> body;
}
