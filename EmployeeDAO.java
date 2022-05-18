/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau4;

import java.util.ArrayList;

/**
 *
 * @author Softech
 */
public interface EmployeeDAO {
    public ArrayList<Employee> getAllEmployee();
    public void addEmployee(Employee employee);
    Employee getEmployee(int index);
    public void clear();
}
