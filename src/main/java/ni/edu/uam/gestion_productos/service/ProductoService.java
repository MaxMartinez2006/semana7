package ni.edu.uam.gestion_productos.service;

import ni.edu.uam.gestion_productos.dto.ProductoRequestDTO;
import ni.edu.uam.gestion_productos.entity.Categoria;
import ni.edu.uam.gestion_productos.entity.Producto;
import ni.edu.uam.gestion_productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaService categoriaService;

    public ProductoService(
            ProductoRepository productoRepository,
            CategoriaService categoriaService) {

        this.productoRepository = productoRepository;
        this.categoriaService = categoriaService;
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado con id: " + id));
    }

    public Producto guardar(ProductoRequestDTO dto) {

        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId());

        Producto producto = new Producto();

        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setCategoria(categoria);
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());

        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, ProductoRequestDTO dto) {

        Producto producto = buscarPorId(id);

        Categoria categoria = categoriaService.buscarPorId(dto.getCategoriaId());

        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setCategoria(categoria);
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencia(dto.getExistencia());

        return productoRepository.save(producto);
    }

    public void eliminar(Integer id) {

        Producto producto = buscarPorId(id);

        productoRepository.delete(producto);
    }
}