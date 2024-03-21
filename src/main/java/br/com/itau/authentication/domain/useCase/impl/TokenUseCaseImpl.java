package br.com.itau.authentication.domain.useCase.impl;


import br.com.itau.authentication.application.interceptor.exception.BusinessException;
import br.com.itau.authentication.domain.models.Claims;
import br.com.itau.authentication.domain.useCase.TokenUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Set;

import static br.com.itau.authentication.domain.enums.RolesEnum.contains;
import static br.com.itau.authentication.infrastructure.utils.ValidationsUtil.*;
import static java.util.Base64.getUrlDecoder;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenUseCaseImpl implements TokenUseCase {

    /**
     * Este método é responsável por extrair o corpo do token e garantir que o corpo seja de fato um JSON.
     * @param token O JWT presente.
     * @return Retorna o token em formato de String.
     */
    @Override
    public String extractTokenBody(String token) {

        String response = new String(getUrlDecoder().decode(token.split("\\.")[1]));
        validatesIfItIsAJson(response);
        log.info("body present in the extracted token: {}", response);
        return response;

    }

    /**
     * Este método é responsável por garantir que os atributos presentes no token sejam apenas Role, Seed e Name.
     * @param input O corpo presente.
     * @return Caso a validação falhe, ele encerra a thread e retorna false para o usuário.
     */
    @Override
    public void validatesPayloadClaims(String input) {
        if (!new JSONObject(input).keySet().equals(Set.of("Role", "Seed", "Name"))) {
            log.info("The body of the token has fields in addition to Name, Role and Seed");
            throw new BusinessException(Boolean.FALSE.toString());
        }
    }

    /**
     * Este método é responsável por validar se o corpo presente no token atende aos critérios para validar o token com sucesso.
     * A claim Name não pode conter caracteres numéricos.
     * A claim Role deve conter apenas um dos três valores (Admin, Member e External).
     * A claim Seed deve ser um número primo.
     * O tamanho máximo da claim Name é de 256 caracteres.
     * @param claims Corpo do token convertido em objeto.
     */
    @Override
    public void validBodyValues(Claims claims) {

        containsNumbers(claims.getName());
        contains(claims.getRole());
        isPrime(claims.getSeed());
        isValidLength(claims.getName());

    }
}
