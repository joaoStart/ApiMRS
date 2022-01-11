package com.restapi.logapi.logApi.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
