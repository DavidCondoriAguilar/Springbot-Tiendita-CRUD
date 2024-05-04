package com.crudtienda.tienditaspring.repository;

import com.crudtienda.tienditaspring.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoMethods implements ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> findAll() {
        String SQL = "SELECT * FROM producto WHERE estpro = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Producto.class));
    }

    @Override
    public int save(Producto producto) {
        String SQL = "INSERT INTO producto VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, producto.getNompro(), producto.getDespro(),
                producto.getPrepro(), producto.getCanpro(), producto.getEstpro(), producto.getCodpro());
    }

    @Override
    public int update(Producto producto) {
        String SQL = "UPDATE producto SET nompro=?, despro=?, prepro=?, canpro=?, estpro=? WHERE codpro=?";
        return jdbcTemplate.update(SQL, producto.getNompro(), producto.getDespro(),
                producto.getPrepro(), producto.getCanpro(), producto.getEstpro(), producto.getCodpro());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE producto SET estpro = 0 WHERE codpro=?";
        return jdbcTemplate.update(SQL, id);
    }
}