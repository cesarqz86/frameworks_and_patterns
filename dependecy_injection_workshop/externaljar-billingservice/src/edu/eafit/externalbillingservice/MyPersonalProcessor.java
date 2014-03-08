package edu.eafit.externalbillingservice;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class MyPersonalProcessor implements TransactionProcessor {

	@Override
	public String getName() {
		return "MyPersonal";
	}

	@Override
	public Boolean charge(int amount) {
		System.out.println(String.format("My Personal charge: %s", amount));
		return true;
	}

}
