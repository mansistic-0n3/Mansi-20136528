package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Info i = new Info();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID ");
		int id= sc.nextInt();
		System.out.println("Enter Name :");
		String name= sc.next();
		System.out.println("Enter Place ");
		String place= sc.next();
		System.out.println("Enter PAN :");
		String pan= sc.next();
		
		i.setCid(id);
		i.setCname(name);
		i.setPlace(place);
		i.setPAN(pan);
		
		session.save(i);
		tx.commit();
		
		System.out.println("Info Added!");


	}

}
