package br.com.itau.validToken.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class ErrorMessage {

    private LocalDateTime timestamp;
    private Integer status;
    private List<Object> errors;

}
