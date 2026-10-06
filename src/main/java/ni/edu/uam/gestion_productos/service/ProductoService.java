package ni.edu.uam.gestion_productos.service;

import ni.edu.uam.gestion_productos.entity.Producto;
import ni.edu.uam.gestion_productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Producto no encontrado con id: " + id
                ));
    }

    public Producto actualizar(Integer id, Producto producto) {
        Producto productoExistente = buscarPorId(id);

        productoExistente.setCodigo(producto.getCodigo());
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setPrecioVenta(producto.getPrecioVenta());
        productoExistente.setExistencia(producto.getExistencia());

        return repository.save(productoExistente);
    }

    public void eliminar(Integer id) {
        Producto producto = buscarPorId(id);
        repository.delete(producto);
    }
}