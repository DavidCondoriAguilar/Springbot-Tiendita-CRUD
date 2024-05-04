package com.crudtienda.tienditaspring.service;

import com.crudtienda.tienditaspring.model.Producto;
import com.crudtienda.tienditaspring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public int save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public int update(Producto producto) {
        return productoRepository.update(producto);
    }

    @Override
    public int deleteById(int id) {
        return productoRepository.deleteById(id);
    }
}