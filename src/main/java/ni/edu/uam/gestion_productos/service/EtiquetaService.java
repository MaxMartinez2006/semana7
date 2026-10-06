package ni.edu.uam.gestion_productos.service;

import ni.edu.uam.gestion_productos.entity.Etiqueta;
import ni.edu.uam.gestion_productos.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Etiqueta> listar() {
        return etiquetaRepository.findAll();
    }

    public Etiqueta buscarPorId(Integer id) {
        return etiquetaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Etiqueta no encontrada con id: " + id));
    }

    public Etiqueta guardar(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public void eliminar(Integer id) {
        Etiqueta etiqueta = buscarPorId(id);
        etiquetaRepository.delete(etiqueta);
    }
}