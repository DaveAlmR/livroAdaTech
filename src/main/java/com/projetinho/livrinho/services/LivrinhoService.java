package com.projetinho.livrinho.services;

import com.projetinho.livrinho.model.Livrinho;
import com.projetinho.livrinho.repository.LivrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("LivrinhoService")
public class LivrinhoService implements IBaseService<Livrinho>{
    @Autowired
    LivrinhoRepository livrinhoRepository;
    @Autowired
    CategoriaService categoriaService;

    @Override
    public void create(Livrinho livrinho) {
        try {
            livrinho.setId(0L);

            var categoria = categoriaService.find(livrinho.getCategoria().getId());
            livrinho.setCategoria(categoria);

            livrinhoRepository.create(livrinho);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar" + e.getMessage());
        }
    }

    @Override
    public Livrinho find(Long id) {
        try {
            var livrinho = livrinhoRepository.find(id);
            if (livrinho == null)
                throw new RuntimeException("livrinho não encontrado");

            return livrinho;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public List<Livrinho> getAll() {
        try {
            return livrinhoRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar livrinhos");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            var livrinho = livrinhoRepository.find(id);
            if (livrinho == null)
                throw new RuntimeException("livrinho não encontrado");

            livrinhoRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, Livrinho livrinho) {
        try {
            var livrinhoToUpdate = livrinhoRepository.find(id);
            if (livrinhoToUpdate == null)
                throw new RuntimeException("livrinho não encontrado");

            livrinhoToUpdate.setName(livrinho.getName());
            var categoria = categoriaService.find(livrinho.getCategoria().getId());
            livrinhoToUpdate.setCategoria(categoria);

            livrinhoRepository.update(livrinhoToUpdate);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }
}
