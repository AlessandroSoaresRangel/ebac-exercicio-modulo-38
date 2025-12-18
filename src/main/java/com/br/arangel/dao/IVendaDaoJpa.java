package com.br.arangel.dao;

import com.br.arangel.dao.generics.IGenericDaoJpa;
import com.br.arangel.exceptions.DAOException;
import com.br.arangel.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDaoJpa<t, e> extends IGenericDaoJpa<t, e> {

    void finalizarVenda(t venda) throws DAOException, TipoChaveNaoEncontradaException;

    void cancelarVenda(t venda) throws DAOException, TipoChaveNaoEncontradaException;

    t consultarComCollection(e id);

}
