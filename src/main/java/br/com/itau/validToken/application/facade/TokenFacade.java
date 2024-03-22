package br.com.itau.validToken.application.facade;

import br.com.itau.validToken.domain.models.TokenRequest;
import br.com.itau.validToken.domain.models.TokenResponse;

public interface TokenFacade {

    TokenResponse validToken(TokenRequest request);
}
