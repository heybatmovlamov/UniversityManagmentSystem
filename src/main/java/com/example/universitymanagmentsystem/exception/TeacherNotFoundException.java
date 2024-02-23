package com.example.universitymanagmentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "You should login")
public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException (){
        super("You should login");
    }
}
