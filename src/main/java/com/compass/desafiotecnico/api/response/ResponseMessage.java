package com.compass.desafiotecnico.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseMessage {
    private int code;
    private String status;
    private String message;

}
