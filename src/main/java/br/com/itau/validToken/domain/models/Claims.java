package br.com.itau.validToken.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor

@Getter
public class Claims {

    // TODO DEPOIS VER DE CONVERTER ISSO AQUI

    private String Role;

    private Integer Seed;

    private String Name;


}

