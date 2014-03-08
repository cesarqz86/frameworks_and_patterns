package edu.eafit.billingservice.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eafit.billingservice.guiceconfiguration.BillingModule;
import edu.eafit.billingservice.guiceconfiguration.ProviderImplementationHolder;
import edu.eafit.billingservice.infraestructure.LoadImplementation;
import edu.eafit.billingservice.services.BillingService;

public class ProcessExecuter {

	private static Map<String, String> implementationsOptions;

	public static void main(String args[]) {

		Injector injector = Guice.createInjector(new BillingModule());

		String principalMenuOption = "";
		do {
			showPrincipalMenu();
			principalMenuOption = readLine();

			// Show implementation types
			if (principalMenuOption.equals("1")) {

				showImplementationMenu();
				String implementationToUse = readLine();
				String implementationName = implementationsOptions
						.get(implementationToUse);
				if (StringUtils.isBlank(implementationName)
						|| StringUtils.isEmpty(implementationName)) {
					implementationName = implementationToUse;
				}
				ProviderImplementationHolder.getInstance()
						.setCurrentImplementation(implementationName);
				BillingService billingService = injector
						.getInstance(BillingService.class);
				System.out
						.println("---------- Inicio ejecución chargeOrder------------");
				System.out.println();
				billingService.chargeOrder(1234);
				System.out.println();
				System.out
						.println("---------- Fin ejecución chargeOrder------------");
			}
		} while (!principalMenuOption.trim().equals("2"));
	}

	private static void showPrincipalMenu() {
		System.out.println("---------------Menu Principal---------------");
		System.out.println("1. Realizar transacciones");
		System.out.println("2. Salir");
		System.out.println("--------------------------------------------");
	}

	private static void showImplementationMenu() {
		Map<String, String> implementationsNames = LoadImplementation
				.getImplementationNames();

		System.out.println("---------------Implementation Menu---------------");

		if (implementationsNames.isEmpty()) {
			System.out
					.println("-------------No hay implementaciones-------------");
		} else {

			implementationsOptions = new HashMap<String, String>();
			int optionIndex = 1;
			for (String implementationName : implementationsNames.values()) {

				System.out.println(String.format("%s. %s", optionIndex,
						implementationName));

				implementationsOptions.put(String.valueOf(optionIndex),
						implementationName);
				optionIndex++;
			}
		}
		System.out.println("------------------------------------------------");
	}

	private static String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
