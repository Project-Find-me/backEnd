package com.example.findme.findme.Exception;

public class FindMeRunTimeException  extends RuntimeException{

        private String msg;

    public FindMeRunTimeException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMessage(){
            return msg;
        }

}
