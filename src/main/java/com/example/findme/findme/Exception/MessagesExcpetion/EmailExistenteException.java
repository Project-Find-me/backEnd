package com.example.findme.findme.Exception.MessagesExcpetion;

import com.example.findme.findme.Exception.FindMeRunTimeException;

public class EmailExistenteException extends FindMeRunTimeException {
    public EmailExistenteException(){
        super("Este Email já está cadastrado");
    }
}
