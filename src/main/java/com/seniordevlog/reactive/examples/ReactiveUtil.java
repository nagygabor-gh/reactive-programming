package com.seniordevlog.reactive.examples;

import com.github.javafaker.Faker;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReactiveUtil {

	private static final Faker FAKER = Faker.instance();

	private ReactiveUtil() {
	}

	private static final Logger logger = Logger.getLogger(ReactiveUtil.class.getName());

	public static Consumer<Object> onNext() {
		return o -> logger.log(Level.INFO, "Received item: {0}", o);
	}

	public static Consumer<Throwable> onError() {
		return err -> logger.log(Level.WARNING, "Error: {0}",  err.getMessage());
	}

	public static Runnable onComplete() {
		return () -> logger.log(Level.INFO, "Completed");
	}

	public static Faker faker() {
		return FAKER;
	}

	public static void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
