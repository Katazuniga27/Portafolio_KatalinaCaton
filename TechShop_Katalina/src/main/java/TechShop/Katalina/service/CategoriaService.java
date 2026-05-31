package TechShop.Katalina.service;

import TechShop.Katalina.domain.Categoria;
import TechShop.Katalina.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    // El repositorio es final para asegurar la inmutabilidad
    private final CategoriaRepository categoriaRepository;

    // Inyección por constructor
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        if (activos) { // Sólo activas...
            return categoriaRepository.findByActivoTrue();
        }
        return categoriaRepository.findAll();
    }
}