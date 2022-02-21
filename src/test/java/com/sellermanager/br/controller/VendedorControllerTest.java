package com.sellermanager.br.controller;

import com.sellermanager.br.entrypoint.controller.VendedorController;
import com.sellermanager.br.core.model.dto.VendedorIn;
import com.sellermanager.br.core.model.dto.VendedorOut;
import com.sellermanager.br.core.model.dto.VendedorOutList;
import com.sellermanager.br.core.service.VendedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendedorControllerTest {

    @InjectMocks
    private VendedorController vendedorController;

    @Mock
    private VendedorService vendedorService;

    private VendedorIn vendedorIn;

    private VendedorOut vendedorOut;

    private List<VendedorOutList> vendedorOutList;

    @BeforeEach
    void setup() {
        vendedorIn = vendedorIn();
        vendedorOut = vendedorOut();
        vendedorOutList = vendedorOutList();
    }

    @Test
    void deveCadastrarVendedorComSucesso() {
        assertDoesNotThrow(() -> vendedorController.cadastraVendedor(vendedorIn), "201 CREATED");
    }

    @Test
    void deveBuscarVendedorComSucesso() {
        when(vendedorService.buscaVendedor(1)).thenReturn(vendedorOut);

        assertDoesNotThrow(() -> vendedorController.buscaVendedor(1), vendedorOut.toString());
    }

    @Test
    void deveBuscarVendedoresComSucesso() {
        when(vendedorService.buscaVendedores()).thenReturn(vendedorOutList);

        assertDoesNotThrow(() -> vendedorController.buscaVendedores(), vendedorOutList.toString());
    }

    VendedorIn vendedorIn() {
        return new VendedorIn("Stephanie", "999999999", 23, "Barueri", "São Paulo", "Oeste");
    }

    VendedorOut vendedorOut() {
        List<String> lista = Arrays.asList("SP", "RJ", "SC");
        return VendedorOut.builder().nome("Stephanie").dataInclusao(LocalDate.now()).estados(lista).build();
    }

    List<VendedorOutList> vendedorOutList() {
        List<String> lista = Arrays.asList("SP", "RJ", "SC");
        VendedorOutList outList = new VendedorOutList("Stephanie", "99999999", 23, "Barueri", "São Paulo", lista);
        return Arrays.asList(outList, outList, outList);
    }
}
