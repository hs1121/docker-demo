package com.example.backend.Util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private T data=null;
    private Integer responseCode=null;
    private String message="";

}
