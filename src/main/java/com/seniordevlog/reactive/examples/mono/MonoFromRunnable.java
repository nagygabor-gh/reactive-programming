package com.seniordevlog.reactive.examples.mono;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import reactor.core.publisher.Mono;

public class MonoFromRunnable {

	private static final Logger logger = Logger.getLogger(MonoFromRunnable.class.getName());

	public static void main(String[] args) {

		Runnable runnable = () -> logger.info("Hello World");
		Mono.fromRunnable(runnable)
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
		Mono.fromRunnable(timeConsumingProcess())
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), () -> logger.info("Process is done, sending message ..."));
	}

	private static Runnable timeConsumingProcess() {
		return () -> {
			ReactiveUtil.sleepSeconds(3);
			logger.info("Operation completed");
		};
	}

}
