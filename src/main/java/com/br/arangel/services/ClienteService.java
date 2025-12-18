package com.br.arangel.services;

import java.util.List;

import javax.ejb.Stateless;


import com.br.arangel.dao.ClienteDaoJpa;
import com.br.arangel.domain.ClienteJpa;
import com.br.arangel.exceptions.DAOException;
import com.br.arangel.services.generics.GenericServiceJpa;

@Stateless
public class ClienteService extends GenericServiceJpa<ClienteJpa, Long> implements IClienteService {

    private ClienteDaoJpa dao;

    public ClienteService(ClienteDaoJpa dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public ClienteJpa buscarPorCpf(Long cpf) throws DAOException {
        try {
            return this.dao.consultarJpa(cpf);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClienteJpa> filtrarClientes(String query) {
        return this.dao.filtrarClientes(query);
    }

}
