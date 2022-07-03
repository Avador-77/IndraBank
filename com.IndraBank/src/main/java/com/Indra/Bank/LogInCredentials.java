package com.Indra.Bank;

import org.apache.commons.lang3.RandomStringUtils;

public class LogInCredentials {

//	private static String userName, pin;
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		LogInCredentials.userName = userName;
//	}
//
//	public String getPin() {
//		return pin;
//	}
//
//	public void setPin(String pin) {
//		LogInCredentials.pin = pin;
//	}

	public void generator(RegForm rgf) throws InterruptedException {
		
		String userName, pin;
		System.out.print("\n\t Generating Username And Unique Pin");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");

		userName = rgf.getFname().substring(0, 3) + "_" + RandomStringUtils.randomAlphanumeric(5);
		rgf.setUserName(userName);
		pin = RandomStringUtils.randomNumeric(4);
		rgf.setPin(pin);
		System.out.println(
				"\n\t Kudos, Your Username And Password Has Been Generated.\n\n\tKindly Don't Share Your Pin With Anyone.");
		System.out.println("\n\tUSERNAME:  " + rgf.getUserName());
		System.out.println("\n\tPIN:  " + rgf.getPin());

	}
	

}
