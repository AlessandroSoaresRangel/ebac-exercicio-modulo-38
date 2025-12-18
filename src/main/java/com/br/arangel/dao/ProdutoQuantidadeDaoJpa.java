package com.br.arangel.dao;

import com.br.arangel.dao.generics.GenericDaoJpa;
import com.br.arangel.domain.ProdutoQuantidadeJpa;

public class ProdutoQuantidadeDaoJpa extends GenericDaoJpa<ProdutoQuantidadeJpa, Long> {
    public ProdutoQuantidadeDaoJpa() {
        super(ProdutoQuantidadeJpa.class);
    }
}
