package br.com.itau.authentication.application.facade;

import br.com.itau.authentication.application.facade.impl.TokenFacadeImpl;
import br.com.itau.authentication.application.interceptor.exception.BusinessException;
import br.com.itau.authentication.dataFiller.DataFiller;
import br.com.itau.authentication.domain.models.TokenResponse;
import br.com.itau.authentication.domain.useCase.TokenUseCase;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.itau.authentication.dataFiller.DataFiller.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TokenFacadeTest {

    @Mock
    private TokenUseCase useCase;

    @InjectMocks
    private TokenFacadeImpl tokenFacade;

    @SneakyThrows
    @Test
    void testValidTokenTokenValid() {
        when(useCase.extractTokenBody(tokenRequestItsValid().getToken())).thenReturn(new Gson().toJson(DataFiller.claimsValid()));
        TokenResponse response = tokenFacade.validToken(tokenRequestItsValid());
        Assertions.assertEquals(tokenResponseTrue().getValid(),response.getValid());
    }

    @Test
    void testValidTokenClaimInvalid() {
        when(useCase.extractTokenBody(tokenRequestClaimInvalid().getToken())).thenReturn(bodyClaimInvalid());
        doThrow(new BusinessException("The body of the token has fields in addition to Name, Role and Seed")).when(useCase).validatesPayloadClaims(bodyClaimInvalid());
        assertThrows(BusinessException.class, () -> tokenFacade.validToken(tokenRequestClaimInvalid()));

    }

}
