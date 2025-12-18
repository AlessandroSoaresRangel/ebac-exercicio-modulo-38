package com.br.arangel.dao;

import com.br.arangel.dao.generics.GenericDaoJpa;
import com.br.arangel.domain.VendaJpa;
import com.br.arangel.exceptions.DAOException;
import com.br.arangel.exceptions.TipoChaveNaoEncontradaException;

public class VendaExcluirDaoJpa extends GenericDaoJpa<VendaJpa, Long> implements IVendaDaoJpa<VendaJpa, Long> {

    public VendaExcluirDaoJpa() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws DAOException, TipoChaveNaoEncontradaException {
        throw new UnsupportedOperationException("Operação não permitida");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws DAOException, TipoChaveNaoEncontradaException {
        throw new UnsupportedOperationException("Operação não permitida");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("Operação não permitida");
    }
}
