package com.sellermanager.br.service.impl;

import com.sellermanager.br.Repository.AtuacaoRepository;
import com.sellermanager.br.Repository.VendedorRepository;
import com.sellermanager.br.model.Vendedor;
import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;
import com.sellermanager.br.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        }).get();
    }
}
