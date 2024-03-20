package br.com.itau.authentication.application.facade.impl;

import br.com.itau.authentication.application.facade.TokenFacade;
import br.com.itau.authentication.domain.models.Claims;
import br.com.itau.authentication.domain.models.TokenRequest;
import br.com.itau.authentication.domain.models.TokenResponse;
import br.com.itau.authentication.domain.useCase.TokenUseCase;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenFacadeImpl implements TokenFacade {

    private final TokenUseCase service;

    /**
     * Esse metodo é responsavel por orquestrar as chamadas necessaria para garantir a validação do token
     * @param request presente o token
     * @return caso todas as validações ocorram com sucesso ele retorna true para o usuario
     */
    @Override
    public TokenResponse validToken(TokenRequest request) {
        log.info("Token received: {}", request.getToken());

        var extractToken = this.service.extractTokenBody(request.getToken());

        this.service.validatesPayloadClaims(extractToken);

        var convertedBody = new Gson().fromJson(extractToken, Claims.class);

        this.service.validBodyValues(convertedBody);

        log.info("Valid token");

        return TokenResponse.builder().valid(Boolean.TRUE).build();


    }
}
