package edu.eafit.billingservice.implementation;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class PaypalCreditCardProcessor implements TransactionProcessor {

	public Boolean charge(int amount) {
		System.out.println(String.format("Paypal charge: %s", amount));
		return true;
	}

	public String getName() {
		return "Paypal";
	}

}
