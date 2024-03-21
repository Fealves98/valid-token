package br.com.itau.authentication.domain.useCase;

import br.com.itau.authentication.application.interceptor.exception.BusinessException;
import br.com.itau.authentication.dataFiller.DataFiller;
import br.com.itau.authentication.domain.useCase.impl.TokenUseCaseImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.itau.authentication.dataFiller.DataFiller.claimsInvalid;

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
