package com.sellermanager.br.core.service;

import com.sellermanager.br.core.model.dto.VendedorIn;
import com.sellermanager.br.core.model.dto.VendedorOutList;
import com.sellermanager.br.core.model.dto.VendedorOut;

import java.util.List;

public interface VendedorService {

    void cadastraVendedor(VendedorIn vendedorIn);

    VendedorOut buscaVendedor(long id);

    List<VendedorOutList> buscaVendedores();
}
