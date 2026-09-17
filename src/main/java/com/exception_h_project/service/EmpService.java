package com.exception_h_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception_h_project.dto.EmpUpdateDto;
import com.exception_h_project.entitiy.Emp;
import com.exception_h_project.exception.EmpAlReadyExistsException;
import com.exception_h_project.exception.NoSuchEmpExistsException;
import com.exception_h_project.repository.EmpRepository;
@Service
public class EmpService {

 private EmpRepository empRepo;
 @Autowired
 private void EmpRepository(EmpRepository empRepo){

    this.empRepo = empRepo;
 }

 public String addemp(Emp emp){
    Emp e = empRepo.findByEname(emp.getEname()).orElse( null);
    
if (e!=null) {
    throw new EmpAlReadyExistsException("EMP with "+ emp.getEname()+ "already exists with name ");
}
empRepo.save(emp);
return "Emp Save Successfully!";

 }

public Emp getEmp(Integer empId){

      Emp e = empRepo.findById(empId).orElse( null);
    
if (e==null) {
    throw new NoSuchEmpExistsException( "Employee with ID " + empId + " does not exist");
}return e;

 }

 public String updateEmp(EmpUpdateDto empDto, Integer empId){

      Emp e = empRepo.findById(empId).orElse( null);

      if(empDto.getEname()==null && empDto.getSal()==null){
        throw new RuntimeException("empty Object not Allowed for updation");
      }
    
if (e==null) {
    throw new NoSuchEmpExistsException( "Employee with ID " + empId + " does not exist");
}
if(empDto.getEname()!=null){
e.setEname(empDto.getEname());
}
 
if(empDto.getSal()!=null){
e.setSal(empDto.getSal());
}
 
empRepo.save(e);
return "Emp updated Successfully";
 }
}


