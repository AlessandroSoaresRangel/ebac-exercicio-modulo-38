package com.br.arangel.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

    public TipoElementoNaoConhecidoException(String msg) {
        super(msg);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
