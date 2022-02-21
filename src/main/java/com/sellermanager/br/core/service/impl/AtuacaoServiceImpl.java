package com.sellermanager.br.core.service.impl;

import com.sellermanager.br.dataprovider.repository.AtuacaoRepository;
import com.sellermanager.br.core.model.model.Atuacao;
import com.sellermanager.br.core.model.dto.AtuacaoIn;
import com.sellermanager.br.core.service.AtuacaoService;
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
