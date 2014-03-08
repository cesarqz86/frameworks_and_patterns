package edu.eafit.billingservice.guiceconfiguration;

public class ProviderImplementationHolder {

	private static ProviderImplementationHolder providerImplementationHolder;
	
	private String currentImplementation;

	private ProviderImplementationHolder(){
		
	}

	public static ProviderImplementationHolder getInstance(){
		if (providerImplementationHolder == null){
			providerImplementationHolder = new ProviderImplementationHolder();
		}
		return providerImplementationHolder;
	}
	
	public String getCurrentImplementation() {
		return this.currentImplementation;
	}
	
	public void setCurrentImplementation(String currentImplementation) {
		this.currentImplementation = currentImplementation;
	}
	
}
