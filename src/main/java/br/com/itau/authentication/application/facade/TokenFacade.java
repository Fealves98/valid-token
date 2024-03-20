package br.com.itau.authentication.application.facade;

import br.com.itau.authentication.domain.models.TokenRequest;
import br.com.itau.authentication.domain.models.TokenResponse;

public interface TokenFacade {

    TokenResponse validToken(TokenRequest request);
}
