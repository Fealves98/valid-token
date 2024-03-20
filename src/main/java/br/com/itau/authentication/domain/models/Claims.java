package br.com.itau.authentication.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor

@Getter
public class Claims {

    // TODO DEPOIS VER DE CONVERTER ISSO AQUI

    private Integer Seed;

    private String Role;

    private String Name;


}

