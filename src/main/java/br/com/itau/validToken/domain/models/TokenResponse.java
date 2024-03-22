package br.com.itau.validToken.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class TokenResponse {

    private Boolean valid;
}
