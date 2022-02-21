package com.sellermanager.br.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@Getter
public class AtuacaoIn {

    @NotBlank
    private String regiao;

    @NotEmpty
    private List<String> estados;
}
