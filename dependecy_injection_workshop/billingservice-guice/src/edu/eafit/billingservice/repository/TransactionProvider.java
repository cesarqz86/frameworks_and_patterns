package edu.eafit.billingservice.repository;

import java.util.Map;

import com.google.inject.Provider;

import edu.eafit.billingservice.guiceconfiguration.ProviderImplementationHolder;
import edu.eafit.billingservice.implementation.PaypalCreditCardProcessor;
import edu.eafit.billingservice.infraestructure.LoadImplementation;
import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class TransactionProvider implements Provider<TransactionProcessor> {

	public TransactionProvider() {
	}

	public TransactionProcessor get() {

		Map<String, TransactionProcessor> implementationsByName;
		implementationsByName = LoadImplementation.getImplementation();

		String implementationToUse = ProviderImplementationHolder.getInstance()
				.getCurrentImplementation();
		TransactionProcessor processor = implementationsByName
				.get(implementationToUse);
		if (processor == null) {
			processor = new PaypalCreditCardProcessor();
		}
		return processor;
	}
}
