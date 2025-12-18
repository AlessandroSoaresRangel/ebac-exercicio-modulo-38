package com.br.arangel.dao;

import com.br.arangel.dao.generics.GenericDaoJpa;
import com.br.arangel.domain.ClienteJpa;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClienteDaoJpa extends GenericDaoJpa<ClienteJpa, Long> implements IClienteDaoJpa<ClienteJpa> {

    public ClienteDaoJpa() {
        super(ClienteJpa.class, "postgres1");
    }

    @Override
    public List<ClienteJpa> filtrarClientes(String query) {
        TypedQuery<ClienteJpa> tpQuery = this.manager.createQuery("ClienteJpa.findByNome", this.persistentClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
    }
}
