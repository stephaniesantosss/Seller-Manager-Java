package com.sellermanager.br.service;

import com.sellermanager.br.model.dto.VendedorIn;
import com.sellermanager.br.model.dto.VendedorOut;
import com.sellermanager.br.model.dto.VendedorOutList;

import java.util.List;

public interface VendedorService {

    void cadastraVendedor(VendedorIn vendedorIn);

    VendedorOut buscaVendedor(long id);

    List<VendedorOutList> buscaVendedores();
}
