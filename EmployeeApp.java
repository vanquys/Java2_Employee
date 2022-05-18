/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Softech
 */
public class EmployeeApp {

    EmployeeDAO employeeManagement = new EmployeeDAOimpl();
    public void run(){
        int choose=0;
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            displayMenu();
            choose = Integer.parseInt(scanner.nextLine());
            executeFunction(choose);
            if(choose == 5){
                break;
            }
        }
    }

    private static void displayMenu(){
        System.out.println("-----------------MENU------------------");
        System.out.println("An 1. Nhap Employee");
        System.out.println("An 2. In danh sach Employee");
        System.out.println("An 3. Save to file");
        System.out.println("An 4. Read list from file");
        System.out.println("An 5. Thoat chuong trinh");
        System.out.print("Moi chon: ");
    }

    private void displayHeader(){
        System.out.println("--------------------EMPLOYEE MANAGEMENT--------------------");
        System.out.printf("%-10s %-20s %-20s %-10s\n","Id", "Name", "Address", "Age");
    }

    private void displayEmployee(){
        displayHeader();
        ArrayList<Employee> emList = employeeManagement.getAllEmployee();
        for(Employee em : emList)
            em.display();
        System.out.println("-----------------------------------------------------------\n\n\n\n");
    }

    private void addEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Id: ");
        int id=0;
        int age=0;
        while(true){
            try{
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException ex){
                System.out.print("Chi duoc nhap so, nhap lai: ");
            }
        }
        System.out.print("Nhap Name: ");
        String name = scanner.nextLine();
        System.out.print("Nhap Address: ");
        String address = scanner.nextLine();
        System.out.print("Nhap Age: ");
        while(true){
            try{
                age = Integer.parseInt(scanner.nextLine());
                break;
            }catch(NumberFormatException ex){
                System.out.print("Chi duoc nhap so, nhap lai: ");
            }
        }
        employeeManagement.addEmployee(new Employee(id, name, address, age));
    }

    private void saveToFile(String pathFile){
        ArrayList<Employee> emList = employeeManagement.getAllEmployee();
        FileOutputStream fileOutStream = null;
        ObjectOutputStream objectOutStream = null;
        try{
            fileOutStream = new FileOutputStream(pathFile);
            objectOutStream = new ObjectOutputStream(fileOutStream);
            for(Employee s : emList){
                objectOutStream.writeObject(s);
            }
            System.out.println("Ghi thanh cong");
        }
        catch(IOException ex){
            System.out.println(ex.toString());
        }
        finally{
            try{
                if(fileOutStream != null)
                    fileOutStream.close();
                if(objectOutStream != null)
                    objectOutStream.close();
            }
            catch(IOException ex){
                System.out.println(ex.toString());
            }
        }
    }

    private void readFromFile(String pathFile){
        FileInputStream fileInStream = null;
        ObjectInputStream objectInStream = null;
        //list.clear();
        try{
            fileInStream = new FileInputStream(pathFile);
            objectInStream = new ObjectInputStream(fileInStream);
            Employee obj = (Employee)objectInStream.readObject();
            employeeManagement.clear();
            while(obj != null){
                employeeManagement.addEmployee(obj);
                obj = (Employee)objectInStream.readObject();
            }
        }      
        catch(EOFException ex){
            //ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.toString());
        }
        finally{
            try{
                if(fileInStream != null)
                    fileInStream.close();
                if(objectInStream != null)
                    objectInStream.close();
            }
            catch(IOException ex){
                System.out.println(ex.toString());
            }
        }
    }

    public void executeFunction(int choose){
        switch(choose){
            case 1: 
                addEmployee();
                break;
            case 2:
                displayEmployee();
                break;
            case 3:
                //Save to file
                saveToFile("E:/data.txt");
                break;
            case 4:
                //Read from file
                readFromFile("E:/data.txt");
                displayEmployee();
                break;
            case 5:
                System.out.println("Chuong trinh da thoat");
                break;
            default:
                System.out.println("Nhap sai chuong trinh, Nhap lai");
                break;
        }
    }

    public static void main(String[] args) {
        new EmployeeApp().run();
    }
}
