package edu.eafit.externalbillingservice;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class CopyOfAmexProcessor implements TransactionProcessor {

	@Override
	public String getName() {
		return "copycopy Amex";
	}

	@Override
	public Boolean charge(int amount) {
		System.out.println(String.format("copyAmex charge: %s", amount));
		return true;
	}

}