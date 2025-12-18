package com.br.arangel.services;

import java.util.List;

import com.br.arangel.domain.ClienteJpa;
import com.br.arangel.exceptions.DAOException;
import com.br.arangel.services.generics.IGenericServiceJpa;

public interface IClienteService extends IGenericServiceJpa<ClienteJpa, Long> {

    ClienteJpa buscarPorCpf(Long cpf) throws DAOException;

    List<ClienteJpa> filtrarClientes(String query);
}
