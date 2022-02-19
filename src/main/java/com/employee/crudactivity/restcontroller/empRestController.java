package com.employee.crudactivity.restcontroller;

import com.employee.crudactivity.entity.emp;
import com.employee.crudactivity.service.empService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class empRestController {

        private empService EService;

        public empRestController(empService theEmpService){
            EService=theEmpService;
        }
        @GetMapping("/emp")
        public List<emp> findAll(){
            return EService.findAll();
        }


        @GetMapping("emp/{SsnId}")
        public emp findById(@PathVariable int SsnId) {
            emp theEmp = EService.findBySsn(SsnId);
            if (theEmp == null) {
                throw new RuntimeException("Employee SSN not found: -" + SsnId);
            }
            return theEmp;
        }
        @PostMapping("/emp")
        public emp addEmp (@RequestBody emp theEmp) {
            theEmp.setSsn(0);
            EService.save(theEmp);
            return theEmp;
        }
        @PutMapping("/emp")
        public emp updateEmp(@RequestBody emp theEmp){
            EService.save(theEmp);
            return theEmp;
        }
        @DeleteMapping("/emp/{SsnId}")
        public String deleteById(@PathVariable int SsnId){
            emp temp=EService.findBySsn(SsnId);
            if(temp==null){
                throw new RuntimeException("Employee Ssn not found :"+SsnId);
            }

            EService.deleteBySsn(SsnId);
            return "Employee record deleted with Ssn: "+SsnId;
        }
    }
