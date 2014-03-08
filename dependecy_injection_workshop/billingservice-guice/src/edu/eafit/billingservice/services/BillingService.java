package edu.eafit.billingservice.services;

import com.google.inject.Inject;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class BillingService {

	// private final Logger logger =
	// Logger.getLogger(BillingService.class.getName());

	private final TransactionProcessor processor;

	@Inject
	public BillingService(TransactionProcessor processor) {
		this.processor = processor;
	}

	public boolean chargeOrder(int amount) {
		// logger.info("Billing service charging amount.");
		return processor.charge(amount);
	}

}
