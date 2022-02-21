package com.sellermanager.br.service.impl;

import com.sellermanager.br.repository.AtuacaoRepository;
import com.sellermanager.br.model.Atuacao;
import com.sellermanager.br.model.dto.AtuacaoIn;
import com.sellermanager.br.service.AtuacaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AtuacaoServiceImpl implements AtuacaoService {

    private final AtuacaoRepository atuacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public void cadastraAtuacao(AtuacaoIn atuacaoIn) {
        var atuacao = modelMapper.map(atuacaoIn, Atuacao.class);

        atuacaoRepository.save(atuacao);
    }
}
