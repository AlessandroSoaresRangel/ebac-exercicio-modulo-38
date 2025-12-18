package com.br.arangel.dao;

import com.br.arangel.dao.generics.IGenericDaoJpa;
import com.br.arangel.domain.ClienteJpa;

import java.util.List;

public interface IClienteDaoJpa<T> extends IGenericDaoJpa<T, Long> {

    List<ClienteJpa> filtrarClientes(String query);
}
