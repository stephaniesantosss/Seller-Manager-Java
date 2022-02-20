package com.sellermanager.br.controller.vendedor;

import com.sellermanager.br.controller.api.VendedorControllerAPi;
import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;
import com.sellermanager.br.model.dto.VendedorOutList;
import com.sellermanager.br.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class VendedorController implements VendedorControllerAPi {

    private final VendedorService vendedorService;

    @Override
    public ResponseEntity cadastraVendedor(VendedorIn vendedorIn) {
        vendedorService.cadastraVendedor(vendedorIn);

        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public VendedorOut buscaVendedor(long id) {
        return vendedorService.buscaVendedor(id);
    }

    @Override
    public List<VendedorOutList> buscaVendedores() {
        return vendedorService.buscaVendedores();
    }
}
