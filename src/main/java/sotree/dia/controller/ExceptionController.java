package sotree.dia.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sotree.dia.exception.NoSuchDrugIdException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NoSuchDrugIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response NotFoundException(NoSuchDrugIdException e) {
        e.printStackTrace();
        return new Response("404", "NOT FOUND", e.getNedrugUrl());
    }


    //Response DTO
    @Data
    @AllArgsConstructor
    static class Response {
        private String code;
        private String msg;
        private String nedrugUrl;
    }
}
