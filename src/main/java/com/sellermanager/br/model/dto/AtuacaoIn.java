package com.sellermanager.br.model.dto;

import com.sellermanager.br.model.Atuacao;
import lombok.Getter;

import java.util.List;

@Getter
public class AtuacaoIn {

    private String regiao;
    private List<String> estados;

    public Atuacao toModel() {
        return new Atuacao(regiao, estados);
    }
}
