package com.sellermanager.br.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class VendedorOut {

    private String nome;
    private LocalDate dataInclusao;
    private List<String> estados;
}
