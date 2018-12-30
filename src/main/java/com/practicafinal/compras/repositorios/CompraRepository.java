package com.practicafinal.compras.repositorios;

import com.practicafinal.compras.entidades.Cliente;
import com.practicafinal.compras.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    Compra findByCliente(Cliente cliente);

}
