package org.shobhank.design.spring.springdata.dao;

import org.shobhank.design.spring.springdata.model.Employee;
/**
 * Created by shobhanksharma on 5/19/17.
 */
public interface EmployeeDAO {
    public int save(Employee emp);
    public void update(Employee emp);
    public void deleteById(int id);
}
