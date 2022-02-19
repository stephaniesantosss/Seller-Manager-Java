package com.sellermanager.br.controller.vendedor;

import com.sellermanager.br.Repository.VendedorRepository;
import com.sellermanager.br.controller.api.VendedorControllerAPi;
import com.sellermanager.br.model.Vendedor;
import com.sellermanager.br.model.dto.VendedorIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class VendedorController implements VendedorControllerAPi {

    private final VendedorRepository vendedorRepository;

    @Override
    public ResponseEntity cadastraVendedor(VendedorIn vendedorIn) {
        Vendedor vendedor = vendedorIn.toModel();
        vendedorRepository.save(vendedor);

        return ResponseEntity.status(CREATED).build();
    }
}
