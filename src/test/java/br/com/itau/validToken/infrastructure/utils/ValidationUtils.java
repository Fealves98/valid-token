package br.com.itau.validToken.infrastructure.utils;

import br.com.itau.validToken.application.interceptor.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static br.com.itau.validToken.infrastructure.utils.ValidationsUtil.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtils {

    @Test
    void testContainsNumberSucess() {
        assertDoesNotThrow(() -> containsNumbers("Felipe"));
    }

    @Test
    void testContainsNumberFailed() {
        assertThrows(BusinessException.class, () -> containsNumbers("Felipe123"));
    }

    @Test
    void testIsPrimeSucess(){
        assertDoesNotThrow(() -> isPrime(7841));
    }

    @Test
    void testIsPrimeFailed(){
        assertThrows(BusinessException.class,() -> isPrime(50));
    }

    @Test
    void testIsValidLenghtSucess(){
        assertDoesNotThrow(() -> isValidLength("Felipe"));
    }


    @Test
    void testIsValidLenghtFailer(){
        assertThrows(BusinessException.class,() -> isValidLength("Felipe".repeat(300)));
    }
}
