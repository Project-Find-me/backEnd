package com.example.findme.findme.domain;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class AvatarUsuario {

    @Lob
    private String base64;

    private String type;
}
