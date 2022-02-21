package com.sellermanager.br.controller;

import com.sellermanager.br.entrypoint.controller.AtuacaoController;
import com.sellermanager.br.core.model.dto.AtuacaoIn;
import com.sellermanager.br.core.service.AtuacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
public class AtuacaoControllerTest {

    @InjectMocks
    private AtuacaoController atuacaoController;

    @Mock
    private AtuacaoService atuacaoService;

    private AtuacaoIn atuacaoIn;

    @BeforeEach
    void setup() {
        atuacaoIn = atuacaoIn();
    }

    @Test
    void deveCadastrarAtuacaoComSucesso() {
        assertDoesNotThrow(() -> atuacaoController.cadastraAtuacao(atuacaoIn), "201 CREATED");
    }

    AtuacaoIn atuacaoIn() {
        List<String> lista = Arrays.asList("SP", "RG", "SC");
        return new AtuacaoIn("Oeste", lista);
    }
}
