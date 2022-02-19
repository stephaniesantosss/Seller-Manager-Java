package com.sellermanager.br.controller.atuacao;

import com.sellermanager.br.Repository.AtuacaoRepository;
import com.sellermanager.br.controller.api.AtuacaoControllerApi;
import com.sellermanager.br.model.Atuacao;
import com.sellermanager.br.model.dto.AtuacaoIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class AtuacaoController implements AtuacaoControllerApi {

    private final AtuacaoRepository atuacaoRepository;

    @Override
    public ResponseEntity cadastraAtuacao(AtuacaoIn atuacaoIn) {
        Atuacao atuacao = atuacaoIn.toModel();
        atuacaoRepository.save(atuacao);

        return ResponseEntity.status(CREATED).build();
    }
}
