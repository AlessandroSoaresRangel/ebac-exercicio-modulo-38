package com.br.arangel.dao;

import com.br.arangel.dao.generics.GenericDaoJpa;
import com.br.arangel.domain.ProdutoJpa;

public class ProdutoDaoJpa extends GenericDaoJpa<ProdutoJpa, Long> {
    public ProdutoDaoJpa() {
        super(ProdutoJpa.class);
    }
}
