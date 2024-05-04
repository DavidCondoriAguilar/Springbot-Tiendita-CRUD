package com.crudtienda.tienditaspring.controller;

import com.crudtienda.tienditaspring.model.Producto;
import com.crudtienda.tienditaspring.model.ServiceResponse;
import com.crudtienda.tienditaspring.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/producto")
@CrossOrigin("*")

public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> list() {

        var result = iProductoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> saveProducto(@RequestBody Producto producto) {
        ServiceResponse serviceResponse = new ServiceResponse(true, "Item save with success");

        int result = iProductoService.save(producto);
        if (result == 1) {
            serviceResponse.setMessage("Item save with success");
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        } else {
            serviceResponse.setMessage("Failed to save item");
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Producto producto) {
        ServiceResponse serviceResponse = new ServiceResponse();

        int result = iProductoService.update(producto);
        if (result == 1) {
            serviceResponse.setMessage("Item update with success"); // Utiliza setMessage en lugar de setSetMessage
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }


    @PostMapping("/delete")
    public ResponseEntity<ServiceResponse> delete(@RequestParam int id) {
        ServiceResponse serviceResponse = new ServiceResponse();

        int result = iProductoService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Item deleted successfully");
        } else {
            serviceResponse.setMessage("Failed to delete item");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

}

