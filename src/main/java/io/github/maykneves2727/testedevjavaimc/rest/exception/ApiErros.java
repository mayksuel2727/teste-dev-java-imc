package io.github.maykneves2727.testedevjavaimc.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    @Getter
    private List<String> errors;

    public ApiErros(List<String> errors) {
        this.errors = errors;
    }
    public ApiErros (String message){
        this.errors = Arrays.asList(message);
    }
}
