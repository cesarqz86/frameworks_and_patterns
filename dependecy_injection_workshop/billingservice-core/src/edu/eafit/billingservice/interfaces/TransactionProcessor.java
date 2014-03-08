package edu.eafit.billingservice.interfaces;

public interface TransactionProcessor extends GenericComponent {
	Boolean charge(int amount);
}
