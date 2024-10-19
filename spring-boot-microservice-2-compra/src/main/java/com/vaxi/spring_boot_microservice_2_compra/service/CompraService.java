package com.vaxi.spring_boot_microservice_2_compra.service;

import com.vaxi.spring_boot_microservice_2_compra.model.Compra;

import java.util.List;

public interface CompraService {
    Compra saveCompra(Compra compra);

    void deleteCompra(Long id);

    List<Compra> findAllComprasOfUser(Long userId);
}
