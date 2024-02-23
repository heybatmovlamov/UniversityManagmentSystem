package com.example.universitymanagmentsystem.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class StudentResponse<S> {
    HttpStatus status;
    String msg;
    S data;

    public static <S> StudentResponse<S> success(S data) {
        return StudentResponse.<S>builder().status(HttpStatus.OK)
                .msg("Success")
                .data(data)
                .build();
    }
    public static <S> StudentResponse<S> notFound(S data){
        return StudentResponse.<S>builder().status(HttpStatus.OK)
                .msg("Success")
                .data(data)
                .build();
    }
}
