package com.employee.crudactivity.dao;

import com.employee.crudactivity.entity.emp;

import java.util.List;

public interface EmpDAO {

    public List<emp> findAll();

    public emp findBySsn(int Ssn);

    public void save(emp emp1);

    public void deleteBySsn(int Ssn);
}