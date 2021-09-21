package io.lewiscodes.codesharereact.controllers;

import io.lewiscodes.codesharereact.exceptions.SnippetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiControllerAdvice {
    @ResponseBody
    @ExceptionHandler(SnippetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String snippetNotFoundHandler(SnippetNotFoundException e) {
        return "Snippet not found";
    }
}
