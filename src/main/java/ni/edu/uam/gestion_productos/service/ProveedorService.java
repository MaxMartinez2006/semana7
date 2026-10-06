package ni.edu.uam.gestion_productos.service;

import ni.edu.uam.gestion_productos.entity.Proveedor;
import ni.edu.uam.gestion_productos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor buscarPorId(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Proveedor no encontrado con id: " + id));
    }

    public void eliminar(Integer id) {
        Proveedor proveedor = buscarPorId(id);
        proveedorRepository.delete(proveedor);
    }
}