package br.com.itau.validToken.application.interceptor.exception;

import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class BusinessException extends HystrixBadRequestException implements ExceptionNotWrappedByHystrix {

    public BusinessException(String valid){
        super(String.valueOf(valid));
    }

}
