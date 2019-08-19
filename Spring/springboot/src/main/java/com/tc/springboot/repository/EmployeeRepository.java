package com.tc.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tc.springboot.beans.EmployeeInfoBean;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer>{

}
