package com.compass.desafiotecnico.config.handling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericErrorResponse {

    private int code;
    private String message;

}
