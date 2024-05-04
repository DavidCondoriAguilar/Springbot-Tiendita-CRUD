package com.crudtienda.tienditaspring.repository;

import com.crudtienda.tienditaspring.model.Producto;

import java.util.List;

public interface ProductoRepository {
    List<Producto> findAll();
    int save(Producto producto);
    int update(Producto producto);
    int deleteById(int id);
}
