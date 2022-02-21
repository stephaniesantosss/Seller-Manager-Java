package com.sellermanager.br.dataprovider.repository;

import com.sellermanager.br.core.model.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
