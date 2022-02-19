package com.sellermanager.br.service;

import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;

public interface VendedorService {

    void cadastraVendedor(VendedorIn vendedorIn);

    VendedorOut buscaVendedor(long id);
}
