package com.projetinho.livrinho.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categoria extends IBaseObject{
    private Long id;
    private String name;
}
