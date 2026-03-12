package com.lpu.LearnSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@Data
@AllArgsConstructor
//@ToString
public class ApiResponse <T>{
    private String statusCode;
    private String message;
    private T data;

}
