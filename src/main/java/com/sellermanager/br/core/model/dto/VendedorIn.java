package com.sellermanager.br.core.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class VendedorIn {

    private LocalDate dataInclusao = LocalDate.now();

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotNull
    private int idade;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String regiao;

    public VendedorIn(String nome, String telefone, int idade, String cidade, String estado, String regiao) {
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.regiao = regiao;
    }
}
