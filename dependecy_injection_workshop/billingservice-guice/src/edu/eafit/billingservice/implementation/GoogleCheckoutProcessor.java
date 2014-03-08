package edu.eafit.billingservice.implementation;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class GoogleCheckoutProcessor implements TransactionProcessor {

	public Boolean charge(int amount) {
		System.out.println(String.format("Google checkout charge: %s", amount));
		return true;
	}

	public String getName() {
		return "GoogleCheckout";
	}

}
