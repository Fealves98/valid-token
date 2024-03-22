package br.com.itau.validToken.domain.useCase;

import br.com.itau.validToken.application.interceptor.exception.BusinessException;
import br.com.itau.validToken.dataFiller.DataFiller;
import br.com.itau.validToken.domain.useCase.impl.TokenUseCaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.itau.validToken.dataFiller.DataFiller.claimsInvalid;

@ExtendWith(MockitoExtension.class)
public class TokenUseCaseTest {


    @InjectMocks
    private TokenUseCaseImpl useCase;

    @Test
    void testExtractTokenBodySucess() {
        Assertions.assertDoesNotThrow(() -> useCase.extractTokenBody(DataFiller.tokenRequestItsValid().getToken()));
    }


    @Test
    void testExtractTokenBodyFailed() {
        Assertions.assertThrows(BusinessException.class, () -> useCase.extractTokenBody(DataFiller.tokenRequestJsonInvalid().getToken()));
    }

    @Test
    void testValidBodyValuesSucess() {
        Assertions.assertDoesNotThrow(() -> useCase.validBodyValues(DataFiller.claimsValid()));
    }

    @Test
    void testValidBodyValuesFailed() {
        Assertions.assertThrows(BusinessException.class, () -> useCase.validBodyValues(claimsInvalid()));
    }

}
