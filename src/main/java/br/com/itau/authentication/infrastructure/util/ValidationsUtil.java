package br.com.itau.authentication.infrastructure.util;

import br.com.itau.authentication.application.interceptor.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;

import static java.util.regex.Pattern.matches;

@Slf4j
public class ValidationsUtil {

    /**
     * Esse metodo util verifica se uma string possui caracteres numericos
     * @param input string a ser validada
     * @return no contexto atual da aplicação caso possua caractere numerico ele encerra a thread e retorna false ao usuario
     */
    public static void containsNumbers(String input) {
        if (input.matches(".*\\d.*")) {
            log.info("The claim name contains number characters");
            throw new BusinessException(Boolean.FALSE.toString());
        }

    }

    /**
     * Esse metodo util verifica se o inteiro informado é um numero primo
     * @param input numero a ser validado
     * @return no contexto atual da aplicação caso não seja um numero primo ele encerra o a thread e retorna false ao usuario
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
     * Esse metodo util verifica se a string possui mais de 256 caracteres
     * @param input string a ser validada
     * @return no contexto atual da aplicação caso caso possua msi de 256 ele encerra o a thread e retorna false ao usuario
     */
    public static void isValidLength(String input) {
        if (!matches("^.{0,255}$", input)) {
            log.info("the claim name exceeds the 256 character limit");
            throw new BusinessException(Boolean.FALSE.toString());
        }
    }

    /**
     * Esse metodo util verifica se a string é um Json
     * @param input string a ser validada
     * @return no contexto atual da aplicação caso não seja uma string ele encerra o a thread e retorna false ao usuario
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
