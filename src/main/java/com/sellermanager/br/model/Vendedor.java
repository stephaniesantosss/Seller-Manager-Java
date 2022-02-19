package com.sellermanager.br.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Entity
public class Vendedor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dataInclusao;
    private String nome;
    private String telefone;
    private int idade;
    private String cidade;
    private String estado;
    private String regiao;
}
