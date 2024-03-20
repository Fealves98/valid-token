package br.com.itau.authentication.application.interceptor;

import br.com.itau.authentication.application.interceptor.exception.BusinessException;
import br.com.itau.authentication.domain.models.TokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class Interceptor {

    @ResponseStatus(OK)
    @ExceptionHandler({BusinessException.class})
    public TokenResponse businessException(final  BusinessException businessException){
        return TokenResponse.builder().valid(Boolean.valueOf(businessException.getMessage())).build();
    }
}
