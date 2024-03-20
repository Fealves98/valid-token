package br.com.itau.authentication.domain.useCase;

import br.com.itau.authentication.domain.models.Claims;

public interface TokenUseCase {
    String extractTokenBody(String token);

    void validatesPayloadClaims(String extractToken);

    void validBodyValues(Claims teste);
}
