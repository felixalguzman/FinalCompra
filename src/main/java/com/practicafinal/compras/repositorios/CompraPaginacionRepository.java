package com.practicafinal.compras.repositorios;

import com.practicafinal.compras.entidades.Cliente;
import com.practicafinal.compras.entidades.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompraPaginacionRepository extends PagingAndSortingRepository<Compra, Long> {

    Page<Compra> findAll(Pageable pageable);
    Page<Compra> findAllByCliente(Pageable pageable, Cliente cliente);
}
