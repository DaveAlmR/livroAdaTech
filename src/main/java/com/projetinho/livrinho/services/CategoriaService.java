package com.projetinho.livrinho.services;

import com.projetinho.livrinho.model.Categoria;
import com.projetinho.livrinho.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CategoriaService")
public class CategoriaService implements IBaseService<Categoria>{
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void create(Categoria categoria) {
        try {
            categoria.setId(0L);
            categoriaRepository.create(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar" + e.getMessage());
        }
    }

    @Override
    public Categoria find(Long id) {
        try {
            var categoria = categoriaRepository.find(id);
            if (categoria == null)
                throw new RuntimeException("categoria não encontrado");

            return categoria;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public List<Categoria> getAll() {
        try {
            return categoriaRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar categorias");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            var categoria = categoriaRepository.find(id);
            if (categoria == null)
                throw new RuntimeException("categoria não encontrado");

            categoriaRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, Categoria categoria) {
        try {
            var categoriaToUpdate = categoriaRepository.find(id);
            if (categoriaToUpdate == null)
                throw new RuntimeException("categoria não encontrado");

            categoriaToUpdate.setName(categoria.getName());
            categoriaRepository.update(categoriaToUpdate);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }
}
