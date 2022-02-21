package com.sellermanager.br.core.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
