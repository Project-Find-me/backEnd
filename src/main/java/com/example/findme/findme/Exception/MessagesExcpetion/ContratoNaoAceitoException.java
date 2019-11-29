package com.example.findme.findme.Exception.MessagesExcpetion;

import com.example.findme.findme.Exception.FindMeRunTimeException;

public class ContratoNaoAceitoException extends FindMeRunTimeException {
    public ContratoNaoAceitoException(){
        super("O Contrato não foi aceito!");
    }
}
