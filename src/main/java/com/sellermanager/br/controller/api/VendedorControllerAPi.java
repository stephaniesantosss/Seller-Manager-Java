package com.sellermanager.br.controller.api;

import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/vendedor")
public interface VendedorControllerAPi {

    @ResponseStatus(CREATED)
    @PostMapping
    ResponseEntity cadastraVendedor(@Valid @RequestBody VendedorIn vendedorIn);

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    VendedorOut buscaVendedor(@PathVariable long id);
}
