package com.dam.pc1111;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productos;

    // Spring entrega aquí el repositorio (inyección de dependencias)
    public ProductoController(ProductoRepository productos) {
        this.productos = productos;
    }

    @GetMapping
    public List<Producto> todos() {
        return productos.findAll();
    }

    @GetMapping("/caros")
    public List<Producto> caros(@RequestParam double min) {
        return productos.findByPrecioGreaterThan(min);
    }

    @GetMapping("/buscar")
    public List<Producto> buscar(@RequestParam String texto) {
        return productos.findByNombreContaining(texto);
    }

    @GetMapping("/categoria/{id}")
    public List<Producto> porCategoria(@PathVariable int id) {
        return productos.findByCategoriaId(id);
    }
}
