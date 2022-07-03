package com.Indra.Bank;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LogInPage {
	
	public static void logIn() {
		Scanner sc = new Scanner(System.in);
		String str;
		do {
			System.out.print("Enter your Username: ");
			String userName = sc.nextLine();
			System.out.print("Enter your Pin: ");
			String pin = sc.nextLine();
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			
			RegForm rgf = (RegForm)session.get(RegForm.class, Integer.parseInt(pin));
			if(rgf == null) {
				System.out.println("User not found. Please SignUp!");
			}
			else {
				System.out.println("Wait a minute...We are logging you in");
			}
			session.close();
			factory.close();
			
			System.out.println("\n\t\tDo you want to logIn Again? ('yes' or 'no')");
			str = sc.nextLine();
		}while(str.equalsIgnoreCase("yes"));
		sc.close();
		
	}

}
