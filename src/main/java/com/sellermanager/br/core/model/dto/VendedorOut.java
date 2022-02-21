package com.sellermanager.br.core.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class VendedorOut {

    private String nome;
    private LocalDate dataInclusao;
    private List<String> estados;
}
