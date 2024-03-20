package br.com.itau.authentication.domain.useCase.impl;

//import br.com.itau.authentication.application.interceptor.exception.BusinessException;

import br.com.itau.authentication.application.interceptor.exception.BusinessException;
import br.com.itau.authentication.domain.models.Claims;
import br.com.itau.authentication.domain.useCase.TokenUseCase;
import br.com.itau.authentication.infrastructure.util.ValidationsUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Set;

import static br.com.itau.authentication.domain.enums.RolesEnum.contains;
import static br.com.itau.authentication.infrastructure.util.ValidationsUtil.*;
import static java.util.Base64.getUrlDecoder;

@Service
@Slf4j
public class TokenUseCaseImpl implements TokenUseCase {

    /**
     * Esse metodo é responsavel por extrair o body do token e garantir que body é de fato um JSON
     * @param token presente o JWT
     * @return retorna o token em formato de String
     */
    @Override
    public String extractTokenBody(String token) {

        String response = new String(getUrlDecoder().decode(token.split("\\.")[1]));
        ValidationsUtil.validatesIfItIsAJson(response);
        log.info("body present in the extracted token: {}", response);
        return response;

    }

    /**
     * Esse metodo é responsavel por garantir que os atributos presente no token são apenas Role, Seed, Name
     * @param extractToken presente o Body
     * @return caso a validação falhe ele encerra a thread e retorna false pro usuario
     */
    @Override
    public void validatesPayloadClaims(String extractToken) {
        if (!new JSONObject(extractToken).keySet().equals(Set.of("Role", "Seed", "Name"))) {
            log.info("The body of the token has fields in addition to Name, Role and Seed");
            throw new BusinessException(Boolean.FALSE.toString());
        }
    }

    /**
     * Esse metodo é reponsavel por validar se o body presentem no token, atendem aos criterios para validar o token com sucesso
     * A claim Name não pode ter carácter de números
     * A claim Role deve conter apenas 1 dos três valores (Admin, Member e External)
     * A claim Seed deve ser um número primo.
     * O tamanho máximo da claim Name é de 256 caracteres.
     * @param claims body do token convertido em objeto
     */
    @Override
    public void validBodyValues(Claims claims) {

        containsNumbers(claims.getName());
        contains(claims.getRole());
        isPrime(claims.getSeed());
        isValidLength(claims.getName());

    }
}
