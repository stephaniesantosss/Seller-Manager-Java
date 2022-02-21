package com.sellermanager.br.service;

import com.sellermanager.br.core.model.model.Atuacao;
import com.sellermanager.br.core.model.model.Vendedor;
import com.sellermanager.br.core.model.dto.VendedorIn;
import com.sellermanager.br.dataprovider.repository.AtuacaoRepository;
import com.sellermanager.br.dataprovider.repository.VendedorRepository;
import com.sellermanager.br.core.service.impl.VendedorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VendedorServiceImplTest {

    @InjectMocks
    private VendedorServiceImpl vendedorService;

    @Mock
    private VendedorRepository vendedorRepository;

    @Mock
    private AtuacaoRepository atuacaoRepository;

    @Mock
    private ModelMapper modelMapper;

    private VendedorIn vendedorIn;

    private Vendedor vendedor;

    private Atuacao atuacao;

    private List<Vendedor> vendedorList;

    @BeforeEach
    void setup() {
        vendedorIn = vendedorIn();
        vendedor = vendedor();
        atuacao = atuacao();
        vendedorList = vendedorList();
    }

    @Test
    void deveCadastrarVendedorComSucesso() {
        when(modelMapper.map(vendedorIn, Vendedor.class)).thenReturn(vendedor);

        assertDoesNotThrow(() -> vendedorService.cadastraVendedor(vendedorIn));
    }

    @Test
    void deveBuscarVendedorComSucesso() {
        when(vendedorRepository.findById(1L)).thenReturn(Optional.ofNullable(vendedor));
        when(atuacaoRepository.findById(vendedor.getRegiao())).thenReturn(Optional.ofNullable(atuacao));

        var response = vendedorService.buscaVendedor(1);

        assertNotNull(response);
        assertDoesNotThrow(() -> vendedorService.buscaVendedor(1));
    }

    @Test
    void deveLancar204NaBuscaDeVendedorSeIdVendedorNaoEncontrado() {
        assertThrows(ResponseStatusException.class, () -> vendedorService.buscaVendedor(1), "204 NO_CONTENT");
    }

    @Test
    void deveBuscarVendedores() {
        when(vendedorRepository.findAll()).thenReturn(vendedorList);
        when(atuacaoRepository.findById(vendedor.getRegiao())).thenReturn(Optional.ofNullable(atuacao));

        var response = vendedorService.buscaVendedores();

        assertNotNull(response);
        assertDoesNotThrow(() -> vendedorService.buscaVendedores());
    }

    @Test
    void deveRetornar204NaBuscaDeVendedoresCasoListaRetorneVazia() {
        assertThrows(ResponseStatusException.class, () -> vendedorService.buscaVendedores(), "204 NO_CONTENT");
    }

    VendedorIn vendedorIn() {
        return new VendedorIn("Stephanie", "999999999", 23, "Barueri", "São Paulo", "Oeste");
    }

    Vendedor vendedor() {
        return new Vendedor(1, LocalDate.now(), "Stephanie", "999999999", 23, "Barueri", "São Paulo", "Oeste");
    }

    Atuacao atuacao() {
        var lista = Arrays.asList("SP", "RJ", "SC");
        return new Atuacao("Oeste", lista);
    }

    List<Vendedor> vendedorList() {
        return Arrays.asList(vendedor, vendedor, vendedor);
    }
}
