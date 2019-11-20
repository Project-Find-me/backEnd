package com.example.findme.findme.Exception.MessagesExcpetion;

import com.example.findme.findme.Exception.FindMeRunTimeException;

public class FormaDePagamentoInexistenteException extends FindMeRunTimeException {
    public FormaDePagamentoInexistenteException() {
        super("A forma de pagamento não existe no pagamento com cartão de crédito");
    }
}
