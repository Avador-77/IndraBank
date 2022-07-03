package com.Indra.Bank;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegForm {
	
	@Id
	private int id;
	private String fName, mName, lName, address, email, phNum, aadhaar, dob, userName, pin;
	

	public String getFname() {
		return fName;
	}
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public void setFname(String fname) {
		this.fName = fname;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	// Registration Form
	public void displayRegForm() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"\nWe Are Feeling Happy To Join You In Our Family!!\nKindly Fill The Following Customer Registration Form:");

		System.out.println("\nPlease Verify if You Are A Citizen Of India");
		
		boolean flag = false;
		
		do {

			System.out.print("\n\tEnter Your Aadhaar Number:  ");
			aadhaar = scanner.nextLine();
			aadhaar = aadhaar.replaceAll("\\s", "");
			int actual = aadhaar.length();
			while (actual != 12) {

				System.out.print("\n\tPlease Enter Valid 12 Digit Aadhaar Number Only: ");
				aadhaar = scanner.nextLine();
				actual = aadhaar.length();
			}

			if (Verhoeff.validateVerhoeff(aadhaar) == true) {

				flag = false;
				System.out.println("\n\t---AADHAAR NUMBER VERIFIED---");

			}

			else {
				flag = true;
				System.out.println("\n\tNot A Valid Aadhaar Number.");
			}
		} while (flag);

		System.out.print("\n\tPhone/Mobile Number: ");
		phNum = scanner.nextLine();
		int actual1 = phNum.length();
		while (actual1 != 10) {

			System.out.print("\n\tPlease Enter Valid 10 Digit Phone/Mobile Number Only: ");
			phNum = scanner.nextLine();

			actual1 = phNum.length();
		}

		System.out.print("\n\t---PHONE/MOBILE NUMBER VERIFIED---");

		do {
			System.out.print("\n\n\tDate Of Birth(MMDDYYYY):");
			dob = scanner.nextLine();
			flag = dob.matches("(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])(\\d{4})");
			if (flag) {
				String subYear = dob.substring(4, 8);
				if ((Integer.parseInt(subYear) >= 1900) && (Integer.parseInt(subYear) <= 2021)) {
					System.out.println("\n\t---DATE OF BIRTH VERIFIED---");
					flag = false;
				} else {
					System.out
							.println("\n\tBirth Year Must Be Greater Than Or Equals 1900 And Less Than Or Equals 2021");
					flag = true;
				}
			} else {
				System.out.println("\n\tInvalid DOB Format.");
				flag = true;
			}

		} while (flag);

		System.out.print("\nFirst Name:  ");
		fName = scanner.nextLine();

		System.out.print("\nMiddle Name\n(Press Enter, If You Don't Have Middle Name ):  ");
		scanner.useDelimiter("\n");
		mName = scanner.nextLine();
		if (mName.equals("\n"))
			mName = "";

		System.out.print("\nLast Name:  ");
		lName = scanner.nextLine();

		System.out.print("\nAddress:  ");
		address = scanner.nextLine();

		do {
			System.out.print("\nEmail:  ");
			email = scanner.nextLine();
			flag = email.matches("[\\w]+@[\\w]+\\.[a-zA-Z]{2,3}");
			if (flag) {
				System.out.println("\n\t---E-MAIL VERIFIED---");
				flag = false;
			} else {
				System.out.println("\n\tInvalid E-Mail Id.");
				flag = true;
			}
		} while (flag);
		
		scanner.close();

	}

}
