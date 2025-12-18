package com.br.arangel.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.br.arangel.domain.ClienteJpa;
import com.br.arangel.exceptions.DAOException;
import com.br.arangel.exceptions.TipoChaveNaoEncontradaException;
import com.br.arangel.services.ClienteService;
import com.br.arangel.utils.ReplaceUtils;

@Named
@ViewScoped
public class ClienteController implements Serializable{

    private ClienteJpa cliente;
    private Collection<ClienteJpa> clientes;
    private ClienteService service;
    private Boolean isUpdated;
    private String cpfMask;
    private String telMask;

    @PostConstruct
    public void init() {
        try {
            this.isUpdated = false;
            this.cliente = new ClienteJpa();
            this.clientes = this.service.buscarTodos();
        } catch (DAOException e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));

        }
    }

    public void cancel() {
        try {
            this.isUpdated = false;
            this.cliente = new ClienteJpa();
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar a ação"));

        }
    }

    public void edit(ClienteJpa cliente) {
        try {
            this.isUpdated = true;
            this.cliente = cliente;
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));

        }
    }

    public void delete(ClienteJpa cliente) {
        try {
            this.service.excluir(cliente);
            this.clientes.remove(cliente);
        } catch (DAOException e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }

    }

    public void add() {
        try{
            this.removerCaracteresInvalidos();
            this.limparCampos();
            this.service.cadastrar(this.cliente);
            this.clientes = this.service.buscarTodos();
            this.cliente = new ClienteJpa();
        } catch (DAOException e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar cliente"));
        }
    }

    public void update() {
        try{
            this.removerCaracteresInvalidos();
            this.service.alterar(this.cliente);
            this.cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualizado com sucesso"));
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (TipoChaveNaoEncontradaException e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar cliente"));
        }
    }

    public String voltarTelaInicial() {
        return "/index.xhtml";
    }

    private void removerCaracteresInvalidos() {
        Long cpf = Long.valueOf(ReplaceUtils.replace(getCpfMask(), ".", "-"));
        this.cliente.setCpf(cpf);

        Long tel = Long.valueOf(ReplaceUtils.replace(getTelMask(), "(", ")", " ", "-"));
        this.cliente.setTel(tel);
    }

    private void limparCampos() {
        setCpfMask(null);
        setTelMask(null);
    }


    public ClienteJpa getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJpa cliente) {
        this.cliente = cliente;
    }

    public Collection<ClienteJpa> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<ClienteJpa> clientes) {
        this.clientes = clientes;
    }

    public String getCpfMask() {
        return cpfMask;
    }

    public void setCpfMask(String cpfMask) {
        this.cpfMask = cpfMask;
    }

    public String getTelMask() {
        return telMask;
    }

    public void setTelMask(String telMask) {
        this.telMask = telMask;
    }
}
