package com.projetinho.livrinho.services;

import com.projetinho.livrinho.model.Aluguel;
import com.projetinho.livrinho.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AluguelService")
public class AluguelService implements IBaseService<Aluguel>{
    @Autowired
    AluguelRepository aluguelRepository;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    LivrinhoService livrinhoService;

    @Override
    public void create(Aluguel aluguel) {
        try {
            aluguel.setId(0L);

            var pessoa = aluguel.getPessoa();
            var livro = aluguel.getLivrinho();

            pessoa = pessoaService.find(pessoa.getId());
            livro = livrinhoService.find(livro.getId());

            aluguel.setPessoa(pessoa);
            aluguel.setLivrinho(livro);

            aluguelRepository.create(aluguel);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao criar" + e.getMessage());
        }
    }

    @Override
    public Aluguel find(Long id) {
        try {
            var aluguel = aluguelRepository.find(id);
            if (aluguel == null)
                throw new RuntimeException("aluguel não encontrado");

            return aluguel;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public List<Aluguel> getAll() {
        try {
            return aluguelRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar aluguels");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            var aluguel = aluguelRepository.find(id);
            if (aluguel == null)
                throw new RuntimeException("aluguel não encontrado");

            aluguelRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, Aluguel aluguel) {
        try {
            var aluguelToUpdate = aluguelRepository.find(id);
            if (aluguelToUpdate == null)
                throw new RuntimeException("aluguel não encontrado");

            aluguelToUpdate.setLimiteDevolucao(aluguel.getLimiteDevolucao());
            aluguelToUpdate.setValor(aluguel.getValor());

            aluguelRepository.update(aluguelToUpdate);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao pegar: " + e.getMessage());
        }
    }
}
