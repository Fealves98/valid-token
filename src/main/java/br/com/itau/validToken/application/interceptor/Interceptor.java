package br.com.itau.validToken.application.interceptor;

import br.com.itau.validToken.application.interceptor.exception.BusinessException;
import br.com.itau.validToken.domain.models.ErrorMessage;
import br.com.itau.validToken.domain.models.TokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class Interceptor {

    @ResponseStatus(OK)
    @ExceptionHandler({BusinessException.class})
    public TokenResponse businessException(final  BusinessException businessException){
        return TokenResponse.builder().valid(Boolean.valueOf(businessException.getMessage())).build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ErrorMessage methodArgumentNotValidException(final  MethodArgumentNotValidException businessException){
        return ErrorMessage.builder().status(businessException.getStatusCode().value()).timestamp(LocalDateTime.now()).errors(stream(businessException.getDetailMessageArguments()).toList()).build();

    }
}
