package com.exception_h_project.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception_h_project.dto.EmpUpdateDto;
import com.exception_h_project.entitiy.Emp;

import com.exception_h_project.service.EmpService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
    @Autowired
    private EmpService serv;

    private EmpController(EmpService serv) {  
        this.serv = serv;
    }

    @PostMapping("add")
    public String addEmp(@Valid @RequestBody Emp emp) {
        return serv.addemp(emp);
    }

    @GetMapping("/{empId}")
    public Emp getEmp(@PathVariable("empId") Integer empId) {

        return serv.getEmp(empId);
    }

    @PutMapping("/update/{empId}")
    public String updateEmp(@Valid @RequestBody EmpUpdateDto  empDTO, @PathVariable("empId") Integer empId) {
        return serv.updateEmp(empDTO, empId);

    }

}
