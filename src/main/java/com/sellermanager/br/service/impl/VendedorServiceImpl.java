package com.sellermanager.br.service.impl;

import com.sellermanager.br.repository.AtuacaoRepository;
import com.sellermanager.br.repository.VendedorRepository;
import com.sellermanager.br.model.Vendedor;
import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;
import com.sellermanager.br.model.dto.VendedorOutList;
import com.sellermanager.br.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NO_CONTENT;


@RequiredArgsConstructor
@Service
public class VendedorServiceImpl implements VendedorService {

    private final VendedorRepository vendedorRepository;
    private final AtuacaoRepository atuacaoRepository;
    private final ModelMapper vendedorMapper;

    @Override
    public void cadastraVendedor(VendedorIn vendedorIn) {
        var vendedor = vendedorMapper.map(vendedorIn, Vendedor.class);
        vendedorRepository.save(vendedor);
    }

    @Override
    public VendedorOut buscaVendedor(long id) {

        return vendedorRepository.findById(id).map(vendedor -> {
            var atuacao = atuacaoRepository.findById(vendedor.getRegiao());

            return VendedorOut.builder()
                    .nome(vendedor.getNome())
                    .dataInclusao(vendedor.getDataInclusao())
                    .estados(atuacao.get().getEstados()).build();
        }).orElseThrow(() -> new ResponseStatusException(NO_CONTENT));
    }

    @Override
    public List<VendedorOutList> buscaVendedores() {
        var list = vendedorRepository.findAll().stream().map(vendedor -> {
            var atuacao = atuacaoRepository.findById(vendedor.getRegiao());
            return VendedorOutList.builder()
                    .nome(vendedor.getNome())
                    .telefone(vendedor.getTelefone())
                    .idade(vendedor.getIdade())
                    .cidade(vendedor.getCidade())
                    .estado(vendedor.getEstado())
                    .estados(atuacao.get().getEstados()).build();
        }).collect(Collectors.toList());

        if (list.isEmpty()) {
            throw new ResponseStatusException(NO_CONTENT);
        }

        return list;
    }
}
