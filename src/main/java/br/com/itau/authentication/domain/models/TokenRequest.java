package br.com.itau.authentication.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class TokenRequest {


    @NotNull
    @NotBlank
    private String token;
}
