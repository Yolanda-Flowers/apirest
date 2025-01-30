package com.yolacode.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolacode.apirest.apirest.Repositories.ProductRepository;
import com.yolacode.apirest.apirest.Entities.Producto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/Productos")
public class ProductoController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<Producto> getAllProductos() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
    }

    @PostMapping("")
    public Producto createProducto(@RequestBody Producto producto) {
        return productRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detailProducto) {
        Producto producto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
        producto.setNombre(detailProducto.getNombre());
        producto.setPrecio((detailProducto.getPrecio()));
        return productRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        productRepository.delete(producto);
        return "El producto con el ID: " + id + "fue eliminado correctamente";
    }
}
