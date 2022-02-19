package com.employee.crudactivity.service;

import com.employee.crudactivity.entity.emp;

import java.util.List;

public interface empService {

    public List<emp> findAll();

    public emp findBySsn(int id);

    public void save(emp theEmp);

    public void deleteBySsn(int id);
}
