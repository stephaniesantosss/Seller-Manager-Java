package com.sellermanager.br.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Atuacao {

    @Id
    private String regiao;

    @ElementCollection
    private List<String> estados;
}
