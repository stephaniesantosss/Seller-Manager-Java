package com.sellermanager.br.entrypoint.controller;

import com.sellermanager.br.entrypoint.controller.api.AtuacaoControllerApi;
import com.sellermanager.br.core.model.dto.AtuacaoIn;
import com.sellermanager.br.core.service.AtuacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class AtuacaoController implements AtuacaoControllerApi {

    private final AtuacaoService atuacaoService;

    @Override
    public ResponseEntity cadastraAtuacao(AtuacaoIn atuacaoIn) {
        atuacaoService.cadastraAtuacao(atuacaoIn);

        return ResponseEntity.status(CREATED).build();
    }
}
