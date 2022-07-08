package com.Indra.Bank;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunApp {

	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);

		System.out.println(
				"\t\t\t\t\t\t**** WELCOME TO INDIRA BANK OF INDIA ****\n\t\t\t\t\t\t     -------------------------------");

		System.out.println("\n\n\t\t\t\tA. New Customer\t\t\t\t\t\t\tB. Existing Customer");

		System.out.println("\nEnter Your Option(A or B):");

		String option = input.nextLine();
		
		switch (option.toUpperCase()) {
		case "A":
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			RegForm rgf = new RegForm();
			rgf.displayRegForm();
			
			rgf.setFname(rgf.getFname());
			
			if (rgf.getmName() != "")
				rgf.setmName(rgf.getmName());
			
			rgf.setlName(rgf.getlName());
			
			rgf.setAddress(rgf.getAddress());
			
			String subAadhar = rgf.getAadhaar();
			subAadhar = subAadhar.substring(0, 4) + " " + subAadhar.substring(4, 8) + " " + subAadhar.substring(8, 12);
			rgf.setAadhaar(rgf.getAadhaar());
			
			rgf.setEmail(rgf.getEmail());
			
			rgf.setPhNum("+91 " + rgf.getPhNum());
			
			String subDob = rgf.getDob();
			subDob = subDob.substring(0, 2) + "/" + subDob.substring(2, 4) + "/" + subDob.substring(4, 8);
			rgf.setDob(rgf.getDob());
			
			LogInCredentials lc = new LogInCredentials();
			lc.generator(rgf);
			
			
			session.save(rgf);
			
			tx.commit();
			
			
			session.close();
			
			
			
			
			break;

		case "B":
			LogInPage.logIn();
			break;
		default:
			System.out.println("\nInvalid Option Entered");
		}
		System.out.println(
				"\n\t\t\t\t\t\t\t-----Thank You For Using IBI Bank Services-----\t\t\t\t\t\t\n\t\t\t\t\t\t\t       *****APKA DIN MANGAL MYE RAHE!!*****");
		input.close();

	}

}
