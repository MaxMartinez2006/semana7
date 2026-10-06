package ni.edu.uam.gestion_productos.controller;

import ni.edu.uam.gestion_productos.entity.Etiqueta;
import ni.edu.uam.gestion_productos.service.EtiquetaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
    public List<Etiqueta> listar() {
        return etiquetaService.listar();
    }

    @GetMapping("/{id}")
    public Etiqueta buscarPorId(@PathVariable Integer id) {
        return etiquetaService.buscarPorId(id);
    }

    @PostMapping
    public Etiqueta guardar(@RequestBody Etiqueta etiqueta) {
        return etiquetaService.guardar(etiqueta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        etiquetaService.eliminar(id);
    }
}