package edu.eafit.billingservice.implementation;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class VisaCardProcessor implements TransactionProcessor {

	public Boolean charge(int amount) {
		System.out.println(String.format("Visa charge: %s", amount));
		return true;
	}

	public String getName() {
		return "Visa";
	}

}
