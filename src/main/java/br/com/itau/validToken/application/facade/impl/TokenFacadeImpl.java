package br.com.itau.validToken.application.facade.impl;

import br.com.itau.validToken.application.facade.TokenFacade;
import br.com.itau.validToken.domain.models.Claims;
import br.com.itau.validToken.domain.models.TokenRequest;
import br.com.itau.validToken.domain.models.TokenResponse;
import br.com.itau.validToken.domain.useCase.TokenUseCase;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenFacadeImpl implements TokenFacade {

    private final TokenUseCase useCase;

    /**
     * Esse metodo é responsavel por orquestrar as chamadas necessaria para garantir a validação do token
     * @param request presente o token
     * @return caso todas as validações ocorram com sucesso ele retorna true para o usuario
     */
    @Override
    public TokenResponse validToken(TokenRequest request) {
        log.info("Token received: {}", request.getToken());

        String extractToken = this.useCase.extractTokenBody(request.getToken());

        this.useCase.validatesPayloadClaims(extractToken);

        Claims claims = new Gson().fromJson(extractToken, Claims.class);

        this.useCase.validBodyValues(claims);

        log.info("Valid token");

        return TokenResponse.builder().valid(Boolean.TRUE).build();


    }
}
