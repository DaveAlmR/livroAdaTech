package com.projetinho.livrinho.services;

import java.util.List;

public interface IBaseService<T> {
    void create(T livrinho);
    T find(Long id);
    List<T> getAll();
    void delete(Long id);
    void update(Long id, T livrinho);
}
