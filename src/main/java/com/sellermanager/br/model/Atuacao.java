package com.sellermanager.br.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Getter
@AllArgsConstructor
@Entity
public class Atuacao {

    @Id
    private String regiao;

    @ElementCollection
    private List<String> estados;

    @Deprecated
    public Atuacao() {
    }
}
