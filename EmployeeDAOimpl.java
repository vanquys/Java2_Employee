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
public class EmployeeDAOimpl implements EmployeeDAO{
    ArrayList<Employee> list= null;

    public EmployeeDAOimpl() {
        if(list == null){
            list = new ArrayList<Employee>();
        }
    }
    
    @Override
    public ArrayList<Employee> getAllEmployee() {
        return list;
    }

    @Override
    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    @Override
    public Employee getEmployee(int index) {
        if(index<list.size() && index>=0){
            return list.get(index);
        }
        return null;
    }
    
    public void clear(){
        list.clear();
    }
    
}
