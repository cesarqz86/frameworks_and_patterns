package edu.eafit.billingservice.infraestructure;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import edu.eafit.billingservice.interfaces.TransactionProcessor;

public class LoadImplementation {

	private static Map<String, TransactionProcessor> implementationsByName;
	private static Map<String, String> implementationsNames;
	private static final String FOLDERPATH = "D:/TEMP/JARFILES";

	public static Map<String, TransactionProcessor> getImplementation() {

		implementationsByName = new HashMap<String, TransactionProcessor>();

		try {
			Reflections reflections = new Reflections(
					ClasspathHelper.forPackage("edu.eafit.billingservice"));
			Set<Class<? extends TransactionProcessor>> implementingTypes = reflections
					.getSubTypesOf(TransactionProcessor.class);
			int sizeClasses = implementingTypes.size();
			if (sizeClasses > 0) {
				for (Class<?> myClass : implementingTypes) {
					TransactionProcessor myInstance = (TransactionProcessor) myClass
							.newInstance();
					implementationsByName.put(myInstance.getName(), myInstance);
				}
			}

			File folder = new File(FOLDERPATH);
			if (folder.listFiles().length > 0) {
				for (final File fileEntry : folder.listFiles()) {

					if (fileEntry.isFile()) {
						String fullPathFile = String.format("file:///%s",
								fileEntry.getPath());
						URLClassLoader classLoader = new URLClassLoader(
								new URL[] { new URL(fullPathFile) });
						reflections = new Reflections(
								new ConfigurationBuilder().setUrls(
										ClasspathHelper
												.forClassLoader(classLoader))
										.addClassLoader(classLoader));
						implementingTypes = reflections
								.getSubTypesOf(TransactionProcessor.class);
						sizeClasses = implementingTypes.size();
						if (sizeClasses > 0) {
							for (Class<?> myClass : implementingTypes) {
								TransactionProcessor myInstance = (TransactionProcessor) myClass
										.newInstance();
								implementationsByName.put(myInstance.getName(),
										myInstance);
							}
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return implementationsByName;
	}

	public static Map<String, String> getImplementationNames() {
		implementationsNames = new HashMap<String, String>();
		try {
			Reflections reflections = new Reflections(
					ClasspathHelper.forPackage("edu.eafit.billingservice"));
			Set<Class<? extends TransactionProcessor>> implementingTypes = reflections
					.getSubTypesOf(TransactionProcessor.class);
			int sizeClasses = implementingTypes.size();

			if (sizeClasses > 0) {
				for (Class<?> myClass : implementingTypes) {

					TransactionProcessor myInstance = (TransactionProcessor) myClass
							.newInstance();
					implementationsNames.put(myInstance.getName(),
							myInstance.getName());
				}
			}

			File folder = new File(FOLDERPATH);
			if (folder.listFiles().length > 0) {
				for (final File fileEntry : folder.listFiles()) {

					if (fileEntry.isFile()) {

						String fullPathFile = String.format("file:///%s",
								fileEntry.getPath());

						URLClassLoader classLoader = new URLClassLoader(
								new URL[] { new URL(fullPathFile) });
						reflections = new Reflections(
								new ConfigurationBuilder().setUrls(
										ClasspathHelper
												.forClassLoader(classLoader))
										.addClassLoader(classLoader));
						implementingTypes = reflections
								.getSubTypesOf(TransactionProcessor.class);
						sizeClasses = implementingTypes.size();

						if (sizeClasses > 0) {
							for (Class<?> myClass : implementingTypes) {

								TransactionProcessor myInstance = (TransactionProcessor) myClass
										.newInstance();

								implementationsNames.put(myInstance.getName(),
										myInstance.getName());
							}
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return implementationsNames;
	}

}
