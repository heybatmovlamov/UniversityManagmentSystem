package com.example.universitymanagmentsystem.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeacherResponse<T> {
    HttpStatus status;
    String msg;
    T data;


    public static <T> TeacherResponse<T> success(T data) {
        return TeacherResponse.<T>builder().status(HttpStatus.OK)
                .msg("Success")
                .data(data)
                .build();
    }

    public static <T> TeacherResponse<T> notFound(T data) {
        return TeacherResponse.<T>builder().status(HttpStatus.NOT_FOUND)
                .msg("Not found")
                .data(data)
                .build();
    }

}
