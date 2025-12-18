package com.br.arangel.services.generics;

import java.util.Collection;

import com.br.arangel.exceptions.DAOException;
import com.br.arangel.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericServiceJpa<T, E> {
    T cadastrar(T entity) throws DAOException;

    T consultar(E valor) throws DAOException;

    void excluir(T entity) throws DAOException;

    T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    Collection<T> buscarTodos() throws DAOException;
}
