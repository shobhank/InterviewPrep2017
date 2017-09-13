package org.shobhank.design.spring.springdata;

import org.shobhank.design.spring.springdata.dao.EmployeeDAO;
import org.shobhank.design.spring.springdata.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by shobhanksharma on 5/19/17.
 */
public class SpringDataDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-data.xml");
        EmployeeDAO dao=(EmployeeDAO)context.getBean("employeeDAOImpl");
        Employee emp = new Employee();
        emp.setName("Amy");
        emp.setAge(25);
        int status = dao.save(emp);
        System.out.println(emp.getId());

        // For update
        emp.setId(10);
        emp.setAge(35);

        dao.update(emp);

    }
}
