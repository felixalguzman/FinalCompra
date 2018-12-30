package com.practicafinal.compras.servicios;

import com.practicafinal.compras.entidades.Articulo;
import com.practicafinal.compras.entidades.ArticuloCompra;
import com.practicafinal.compras.entidades.Cliente;
import com.practicafinal.compras.entidades.Compra;
import com.practicafinal.compras.repositorios.ArticuloCompraRepository;
import com.practicafinal.compras.repositorios.CompraPaginacionRepository;
import com.practicafinal.compras.repositorios.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprasServices {


    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ArticuloCompraRepository articuloCompraRepository;

    @Autowired
    private CompraPaginacionRepository compraPaginacionRepository;

    public void crearCompra(Compra compra) {

        compraRepository.save(compra);
    }

    public List<Compra> compraList() {

        return compraRepository.findAll();
    }

    public Compra buscarPorCliente(Cliente cliente) {

        return compraRepository.findByCliente(cliente);
    }

    public List<Compra> comprasPorPaginacion(Pageable pageable) {

        return compraPaginacionRepository.findAll(pageable).getContent();
    }

    public Compra compraPorId(Long id){

        return compraRepository.findById(id).orElse(null);
    }

    public List<Articulo> articulosPorCompra(Long compraId) {

        Compra compra = compraRepository.findById(compraId).orElse(null);
        List<Articulo> articuloList;

        articuloList = new ArrayList<>();
        if (compra != null) {


            for (ArticuloCompra articuloCompra : compra.getArticuloCompras()) {

                articuloList.add(articuloCompra.getArticulo());
            }

        }

        return articuloList;

    }


}
