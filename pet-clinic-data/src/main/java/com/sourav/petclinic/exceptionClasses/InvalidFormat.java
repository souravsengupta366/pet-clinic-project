package com.sourav.petclinic.exceptionClasses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFormat extends RuntimeException{

    public InvalidFormat(){
        super();
    }

    public InvalidFormat(String msg){
        super(msg);
    }

    public InvalidFormat(String msg, Throwable cause){
        super(msg,cause);
    }
}
