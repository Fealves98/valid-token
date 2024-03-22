package br.com.itau.validToken.domain.useCase;

import br.com.itau.validToken.domain.models.Claims;

public interface TokenUseCase {
    String extractTokenBody(String token);

    void validatesPayloadClaims(String extractToken);

    void validBodyValues(Claims teste);
}
