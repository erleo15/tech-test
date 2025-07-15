package ec.net.test.utils;

import java.util.Arrays;

/**
 * Clase para la validacion de los string.
 *
 * @author Hernan Leon
 * @version 1.0, 13/07/2025
 */
public class HandleString {

    public static final String PATTERN_TO_SQL_INJ = "(?i)(\\b(select|insert|delete|update|drop|union|exec|execute|alter|create|truncate|grant|revoke)\\b|--|;|/\\*|\\*/|\\b(or|and)\\b\\s+\\d+=\\d+|\\bchar\\(|\\bconvert\\(|\\bcast\\(|\\bwaitfor\\s+delay\\b|\\bsleep\\(|\\bxp_cmdshell\\b)";

    /**
     * Metodo para verificar si entre los parametros existe un valor nulo o vacio
     *
     * @param params Arreglo de strings a verificar.
     * @return returna true si hay al menos un vacio o nulo en el arreglo.
     */
    public static boolean verifyNullEmpty(String... params) {
        return Arrays.stream(params).anyMatch(param -> param == null || param.isEmpty());
    }

    /**
     * Metodo para verificar un posible SQL INJECTION
     *
     * @param params Arreglo de strings a verificar.
     * @return retorna true si al menos uno tiene posible SQL INJECTION
     */
    public static boolean verifySQLINJ(String... params) {
        return Arrays.stream(params).anyMatch(param -> param.toLowerCase().matches(".*" + PATTERN_TO_SQL_INJ + ".*"));
    }
}
