package br.com.itau.validToken.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class TokenRequest {


    @NotNull
    @NotBlank
    @Pattern(regexp = "(^[\\w-]*\\.[\\w-]*\\.[\\w-]*$)", message = "O input realizado não é um JWT")
    private String token;
}
