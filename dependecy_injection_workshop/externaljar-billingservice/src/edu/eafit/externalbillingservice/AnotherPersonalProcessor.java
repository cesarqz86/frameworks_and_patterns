package edu.eafit.externalbillingservice;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class AnotherPersonalProcessor implements TransactionProcessor {

	@Override
	public String getName() {
		return "AnotherPersonal";
	}

	@Override
	public Boolean charge(int amount) {
		System.out
				.println(String.format("Another Personal charge: %s", amount));
		return true;
	}

}