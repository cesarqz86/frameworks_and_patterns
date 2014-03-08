package edu.eafit.billingservice.guiceconfiguration;

import com.google.inject.AbstractModule;

import edu.eafit.billingservice.interfaces.TransactionProcessor;
import edu.eafit.billingservice.repository.TransactionProvider;

public class BillingModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TransactionProcessor.class).toProvider(TransactionProvider.class);
	}

}
