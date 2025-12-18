package com.br.arangel.services.generics;

import java.util.Collection;

import com.br.arangel.dao.generics.IGenericDaoJpa;
import com.br.arangel.exceptions.DAOException;
import com.br.arangel.exceptions.TipoChaveNaoEncontradaException;

public class GenericServiceJpa<T, E> implements IGenericServiceJpa<T, E> {

    protected IGenericDaoJpa<T, E> dao;

    public GenericServiceJpa(IGenericDaoJpa<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws DAOException {
        return this.dao.cadastrarJpa(entity);
    }

    @Override
    public T consultar(E valor) throws DAOException {
        return this.dao.consultarJpa(valor);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluirJpa(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterarJpa(entity);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodosJpa();
    }
}
