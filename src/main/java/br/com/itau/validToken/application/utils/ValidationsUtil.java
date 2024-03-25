package br.com.itau.validToken.application.utils;

import br.com.itau.validToken.application.interceptor.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;

import static java.util.regex.Pattern.matches;

@Slf4j
public class ValidationsUtil {

    /**
     * Este método utilitário verifica se uma string possui caracteres numéricos.
     * @param input String a ser validada.
     * @return No contexto atual da aplicação, caso possua caractere numérico, ele encerra a thread e retorna false ao usuário.
     */
    public static void containsNumbers(String input) {
        if (input.matches(".*\\d.*")) {
            log.info("The claim name contains number characters");
            throw new BusinessException(Boolean.FALSE.toString());
        }

    }

    /**
     * Este método utilitário verifica se o inteiro informado é um número primo.
     * @param input Número a ser validado.
     * @return No contexto atual da aplicação, caso não seja um número primo, ele encerra a thread e retorna false ao usuário.
     */
    public static void isPrime(Integer input) {
        if (input <= 1) {
            log.info("The claim Seed is not a prime number.");
            throw new BusinessException(Boolean.FALSE.toString());
        }

        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                log.info("The claim Seed is not a prime number.");
                throw new BusinessException(Boolean.FALSE.toString());
            }

        }
    }
    /**
     * Este método utilitário verifica se a string possui mais de 256 caracteres.
     * @param input String a ser validada.
     * @return No contexto atual da aplicação, caso possua mais de 256 caracteres, ele encerra a thread e retorna false ao usuário.
     */
    public static void isValidLength(String input) {
        if (!matches("^.{0,255}$", input)) {
            log.info("the claim name exceeds the 256 character limit");
            throw new BusinessException(Boolean.FALSE.toString());
        }
    }

    /**
     * Este método utilitário verifica se a string é um JSON.
     * @param input String a ser validada.
     * @return No contexto atual da aplicação, caso não seja um JSON, ele encerra a thread e retorna false ao usuário.
     */
    public static void validatesIfItIsAJson(String input) {
        try {
            new JSONObject(input);
        } catch (JSONException ex) {
            log.info("Token decode failed, error message: {}", ex.getMessage());
            throw new BusinessException(Boolean.FALSE.toString());
        }

    }
}
