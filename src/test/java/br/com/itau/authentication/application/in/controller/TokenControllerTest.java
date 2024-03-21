package br.com.itau.authentication.application.in.controller;

import br.com.itau.authentication.application.facade.TokenFacade;
import br.com.itau.authentication.dataFiller.DataFiller;
import br.com.itau.authentication.domain.models.TokenResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TokenControllerTest {

    @Mock
    private TokenFacade facade;
    @InjectMocks
    private TokenController controller;

    @Test
    void testValidToken()  {
        when(facade.validToken(Mockito.any())).thenReturn(DataFiller.tokenResponseTrue());
        TokenResponse actualResponse = controller.validToken(DataFiller.tokenRequestItsValid());
        assertEquals(DataFiller.tokenResponseTrue().getValid(), actualResponse.getValid());

    }

}
