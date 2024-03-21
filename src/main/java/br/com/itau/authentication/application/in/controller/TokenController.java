package br.com.itau.authentication.application.in.controller;

import br.com.itau.authentication.application.facade.TokenFacade;
import br.com.itau.authentication.domain.models.TokenRequest;
import br.com.itau.authentication.domain.models.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/v1")
public class TokenController {

    private final TokenFacade facade;

    @ResponseStatus(OK)
    @PostMapping("/token")
    public TokenResponse validToken(@RequestBody TokenRequest request) {
        log.info("------------------------");
        return facade.validToken(request);
    }


}
