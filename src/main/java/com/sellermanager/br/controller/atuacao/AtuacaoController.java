package com.sellermanager.br.controller.atuacao;

import com.sellermanager.br.controller.api.AtuacaoControllerApi;
import com.sellermanager.br.model.dto.AtuacaoIn;
import com.sellermanager.br.service.AtuacaoService;
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
