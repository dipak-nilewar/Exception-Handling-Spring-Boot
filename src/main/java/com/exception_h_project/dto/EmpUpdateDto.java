package com.exception_h_project.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpUpdateDto {
    @Size(min = 1, message = "Ename connot be empty") 
    private String Ename;
    @Min(value = 10000, message = "Salary must be at least 10000")
    private Double Sal;


}
