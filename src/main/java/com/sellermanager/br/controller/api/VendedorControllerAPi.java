package com.sellermanager.br.controller.api;

import com.sellermanager.br.model.dto.VendedorIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

public interface VendedorControllerAPi {

    @ResponseStatus(CREATED)
    @PostMapping("/vendedor")
    ResponseEntity cadastraVendedor(@Valid @RequestBody VendedorIn vendedorIn);
}
