package com.practicafinal.compras.repositorios;

import com.practicafinal.compras.entidades.ArticuloCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloCompraRepository extends JpaRepository<ArticuloCompra, Long> {


}
