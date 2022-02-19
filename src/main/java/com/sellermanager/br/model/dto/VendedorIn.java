package com.sellermanager.br.model.dto;

import com.sellermanager.br.model.Vendedor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class VendedorIn {

    private String nome;
    private String telefone;
    private int idade;
    private String cidade;
    private String estado;
    private String regiao;

    public Vendedor toModel() {
        return new Vendedor(0, LocalDate.now(), nome, telefone, idade, cidade, estado, regiao);
    }
}
