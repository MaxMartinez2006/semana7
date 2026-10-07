package ni.edu.uam.gestion_productos.controller;

import ni.edu.uam.gestion_productos.dto.ProductoRequestDTO;
import ni.edu.uam.gestion_productos.entity.Producto;
import ni.edu.uam.gestion_productos.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Integer id) {
        return productoService.buscarPorId(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> listarPorCategoria(
            @PathVariable Integer categoriaId) {

        return productoService.listarPorCategoria(categoriaId);
    }

    @PostMapping
    public Producto guardar(@RequestBody ProductoRequestDTO dto) {
        return productoService.guardar(dto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Integer id,
            @RequestBody ProductoRequestDTO dto) {

        return productoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
    }

    // Agregar etiqueta a un producto
    @PutMapping("/{productoId}/etiquetas/{etiquetaId}")
    public Producto agregarEtiqueta(
            @PathVariable Integer productoId,
            @PathVariable Integer etiquetaId) {

        return productoService.agregarEtiqueta(
                productoId,
                etiquetaId
        );
    }

    // Reto 1: eliminar asociación Producto-Etiqueta
    @DeleteMapping("/{productoId}/etiquetas/{etiquetaId}")
    public void eliminarEtiqueta(
            @PathVariable Integer productoId,
            @PathVariable Integer etiquetaId) {

        productoService.eliminarEtiqueta(
                productoId,
                etiquetaId
        );
    }
}