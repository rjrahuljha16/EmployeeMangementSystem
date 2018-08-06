package com.ems.userInterface;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.controller.AppController;
import com.ems.employee.Employee;

public class UserInterface {

	public UserInterface() throws IOException
	{
		acceptData();
	}
	ApplicationContext context= new ClassPathXmlApplicationContext("contextproperty.xml");

	AppController appControl= (AppController) context.getBean("controller");
	//=new AppController();
	Scanner scanner= new Scanner(System.in);
	public void acceptData() throws IOException
	{
		Employee employee= new Employee();
		
		
		for(int i=0;i<2;i++)
		{
			System.out.println("Enter the name,id and salary of the employee");
			employee= new Employee(scanner.next(),scanner.nextInt(),scanner.nextInt());
			appControl.addEmployee(employee);
		}
		
		displayData();
		
		System.out.println("Enter the EmployID of the employee to be deleted");
		appControl.deleteEmployee(scanner.nextInt());
		
		System.out.println("After deletion the list of employees is given below");
		displayData();
		
		System.out.println("Enter the EmployID of the employee to be SEARCHED");
		appControl.getEmployeeByID(scanner.nextInt());
		
	}
	
	public void displayData()
	{
		System.out.println("All the employees are listed below: ");
		appControl.viewALlEmployee();
		
		LinkedHashSet<Employee> set=new LinkedHashSet<>();
	
		set.stream().forEach(System.out::println);
	}

//	public void newUI() throws IOException {
//		acceptData();		
//		
//	}
	
}
