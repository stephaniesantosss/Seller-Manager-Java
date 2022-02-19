package com.sellermanager.br.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
public class AtuacaoIn {

    @NotBlank
    private String regiao;

    @NotEmpty
    private List<String> estados;
}
