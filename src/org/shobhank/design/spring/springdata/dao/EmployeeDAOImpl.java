package org.shobhank.design.spring.springdata.dao;

import org.shobhank.design.spring.springdata.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by shobhanksharma on 5/19/17.
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    final String INSERT_QUERY = "insert into employee (name, age) values (?, ?)";
    final String UPDATE_QUERY = "update employee set age = ? where id = ?";
    final String DELETE_QUERY = "delete from employee where id = ?";

    @Override
    public int save(Employee emp) {
        return jdbcTemplate.update(INSERT_QUERY, emp.getName(), emp.getAge());
    }

    @Override
    public void update(Employee emp) {
        int status = jdbcTemplate.update(UPDATE_QUERY,emp.getAge(), emp.getId());
        if(status!=0)
            System.out.println("Employee record updated for " + emp.getId());
        else
            System.out.println("No update");
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void deleteById(int id) {

    }
}
