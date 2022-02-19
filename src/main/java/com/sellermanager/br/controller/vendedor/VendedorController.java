package com.sellermanager.br.controller.vendedor;

import com.sellermanager.br.Repository.AtuacaoRepository;
import com.sellermanager.br.Repository.VendedorRepository;
import com.sellermanager.br.controller.api.VendedorControllerAPi;
import com.sellermanager.br.model.Vendedor;
import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class VendedorController implements VendedorControllerAPi {

    private final VendedorRepository vendedorRepository;
    private final AtuacaoRepository atuacaoRepository;

    @Override
    public ResponseEntity cadastraVendedor(VendedorIn vendedorIn) {
        Vendedor vendedor = vendedorIn.toModel();
        vendedorRepository.save(vendedor);

        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public VendedorOut buscaVendedor(long id) {
        var vendedor = vendedorRepository.findById(id);
        var atuacao = atuacaoRepository.findById(vendedor.get().getRegiao());

        return new VendedorOut(vendedor.get().getNome(), vendedor.get().getDataInclusao(), atuacao.get().getEstados());
    }
}
