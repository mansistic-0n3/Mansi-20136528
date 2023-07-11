package com;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeFile e = (EmployeeFile)context.getBean("emp");
		System.out.println(e.getEmpId() +" : "+ e.getEmpName());

		ArrayList<String> prog = e.getProgLang();
		System.out.println("Programming language-");
		for(String s: prog) {
			System.out.println("  "+s);
		}

	}

}
