package com.sellermanager.br.service;

import com.sellermanager.br.core.model.model.Atuacao;
import com.sellermanager.br.core.model.dto.AtuacaoIn;
import com.sellermanager.br.dataprovider.repository.AtuacaoRepository;
import com.sellermanager.br.core.service.impl.AtuacaoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtuacaoServiceImplTest {

    @InjectMocks
    private AtuacaoServiceImpl atuacaoService;

    @Mock
    private AtuacaoRepository atuacaoRepository;

    private AtuacaoIn atuacaoIn;

    @Mock
    private ModelMapper modelMapper;

    private Atuacao atuacao;

    @BeforeEach
    void setup() {
        atuacaoIn = atuacaoIn();
        atuacao = atuacao();
    }

    @Test
    void deveCadastrarAtuacaoComSucesso() {
        when(modelMapper.map(atuacaoIn, Atuacao.class)).thenReturn(atuacao);

        assertDoesNotThrow(() -> atuacaoService.cadastraAtuacao(atuacaoIn));
    }

    AtuacaoIn atuacaoIn() {
        List<String> lista = Arrays.asList("SP", "RJ", "SC");
        return new AtuacaoIn("Oeste", lista);
    }

    Atuacao atuacao() {
        List<String> lista = Arrays.asList("SP", "RJ", "SC");
        return new Atuacao("Oeste", lista);
    }
}
