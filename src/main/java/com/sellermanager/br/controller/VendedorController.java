package com.sellermanager.br.controller;

import com.sellermanager.br.model.Vendedor;
import com.sellermanager.br.Repository.VendedorRepository;
import com.sellermanager.br.model.dto.VendedorIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class VendedorController {

    private final VendedorRepository vendedorRepository;

    @PostMapping("/vendedor")
    public ResponseEntity cadastraVendedor(@RequestBody VendedorIn vendedorIn) {
        Vendedor vendedor = vendedorIn.toModel();
        vendedorRepository.save(vendedor);

        return ResponseEntity.status(CREATED).build();
    }
}
