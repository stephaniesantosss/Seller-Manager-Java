package com.sellermanager.br.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class VendedorOutList {

    private String nome;
    private String telefone;
    private int idade;
    private String cidade;
    private String estado;
    private List<String> estados;
}
