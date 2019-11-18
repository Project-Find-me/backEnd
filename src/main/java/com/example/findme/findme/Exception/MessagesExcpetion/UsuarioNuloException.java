package com.example.findme.findme.Exception.MessagesExcpetion;

import com.example.findme.findme.Exception.FindMeRunTimeException;

public class UsuarioNuloException extends FindMeRunTimeException {
    public UsuarioNuloException(){
        super("Usuario é nulo, não foi encontrado");
    }
}
