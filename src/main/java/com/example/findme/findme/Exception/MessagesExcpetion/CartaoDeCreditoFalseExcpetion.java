package com.example.findme.findme.Exception.MessagesExcpetion;

import com.example.findme.findme.Exception.FindMeRunTimeException;

public class CartaoDeCreditoFalseExcpetion extends FindMeRunTimeException {
    public CartaoDeCreditoFalseExcpetion(){
        super("Este pagamento não foi solicitado com cartão de crédito");
    }
}
