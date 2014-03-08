package edu.eafit.externalbillingservice;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class AmexProcessor implements TransactionProcessor {

	@Override
	public String getName() {
		return "Amex";
	}

	@Override
	public Boolean charge(int amount) {
		System.out.println(String.format("Amex charge: %s", amount));
		return true;
	}

}