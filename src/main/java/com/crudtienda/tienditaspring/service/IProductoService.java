package com.crudtienda.tienditaspring.service;

import com.crudtienda.tienditaspring.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    int save(Producto producto);
    int update(Producto producto);
    int deleteById(int id);
}