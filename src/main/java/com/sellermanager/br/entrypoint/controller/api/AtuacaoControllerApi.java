package com.sellermanager.br.entrypoint.controller.api;

import com.sellermanager.br.core.model.dto.AtuacaoIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

public interface AtuacaoControllerApi {

    @ResponseStatus(CREATED)
    @PostMapping("/atuacao")
    ResponseEntity cadastraAtuacao (@Valid @RequestBody AtuacaoIn atuacaoIn);
}
