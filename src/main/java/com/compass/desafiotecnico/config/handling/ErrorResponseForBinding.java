package com.compass.desafiotecnico.config.handling;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponseForBinding {
    private String campo;
    private String erro;

}
