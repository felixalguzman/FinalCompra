package com.practicafinal.compras.controladores;

import com.practicafinal.compras.entidades.Cliente;
import com.practicafinal.compras.entidades.Compra;
import com.practicafinal.compras.servicios.ComprasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompraController {

    @Autowired
    private ComprasServices comprasServices;

    @GetMapping(value = "/compras")
    public ResponseEntity<List<Compra>> listarCompras(){

        return new ResponseEntity<>(comprasServices.compraList(), HttpStatus.OK);
    }

    @PostMapping("/compras")
    public ResponseEntity<Compra> crearCompra(@RequestBody Compra compra){

        comprasServices.crearCompra(compra);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/compras/cliente")
    public ResponseEntity<Compra> comprasPorCliente(@RequestBody Cliente cliente){

        return new ResponseEntity<>(comprasServices.buscarPorCliente(cliente), HttpStatus.OK);
    }

    @RequestMapping(value = "/compras/", method = RequestMethod.GET, params = {"limit", "offset"})
    public ResponseEntity<List<Compra>> comprasPorPaginacion(@RequestParam("limit") int limit, @RequestParam("offset") int offset){

        Pageable pageable = PageRequest.of(offset, limit);
        return new ResponseEntity<>(comprasServices.comprasPorPaginacion(pageable), HttpStatus.OK);
    }

    @GetMapping("/compras/{id}")
    public ResponseEntity<Compra> compraPorId(@PathVariable Long id){

        return new ResponseEntity<>(comprasServices.compraPorId(id), HttpStatus.OK);
    }
}
