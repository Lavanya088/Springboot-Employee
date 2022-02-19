package com.employee.crudactivity.service;

import com.employee.crudactivity.dao.EmpDAO;
import com.employee.crudactivity.entity.emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class empServiceImpl implements empService{


    private EmpDAO EDAO;
    @Autowired
    public empServiceImpl(EmpDAO theEmpDAO){
        EDAO=theEmpDAO;
    }
    @Transactional
    public List<emp> findAll(){
        return EDAO.findAll();
    }
    @Transactional
    public emp findBySsn(int id) {
        return EDAO.findBySsn(id);
    }
    @Transactional
    public void save(emp theEmp) {
        EDAO.save(theEmp);
    }
    @Transactional
    public void deleteBySsn(int id) {
        EDAO.deleteBySsn(id);
    }
}

