package com.projetinho.livrinho.services;

import com.projetinho.livrinho.model.Pessoa;
import com.projetinho.livrinho.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PessoaService")
public class PessoaService implements IBaseService<Pessoa>{
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void create(Pessoa pessoa) {
        try {
            pessoa.setId(0L);
            pessoaRepository.create(pessoa);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar" + e.getMessage());
        }
    }

    @Override
    public Pessoa find(Long id) {
        try {
            var pessoa = pessoaRepository.find(id);
            if (pessoa == null)
                throw new RuntimeException("pessoa não encontrado");

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public List<Pessoa> getAll() {
        try {
            return pessoaRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar pessoas");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            var pessoa = pessoaRepository.find(id);
            if (pessoa == null)
                throw new RuntimeException("pessoa não encontrado");

            pessoaRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, Pessoa pessoa) {
        try {
            var pessoaToUpdate = pessoaRepository.find(id);
            if (pessoaToUpdate == null)
                throw new RuntimeException("pessoa não encontrado");

            pessoaToUpdate.setName(pessoa.getName());
            pessoaToUpdate.setAddress(pessoa.getAddress());
            pessoaToUpdate.setPhone(pessoa.getPhone());

            pessoaRepository.update(pessoaToUpdate);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }
}
