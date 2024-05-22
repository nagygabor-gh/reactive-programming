package com.seniordevlog.reactive.examples.mono;

import java.util.logging.Level;
import java.util.logging.Logger;

import reactor.core.publisher.Mono;

public class MonoSubscribeInDetail {

	private static final Logger logger = Logger.getLogger(MonoSubscribeInDetail.class.getName());

	public static void main(String[] args) {
		String data = "test";
		Mono<String> successfulMono = Mono.just(data);
		Mono<Integer> erroneousMono = Mono.just(data).map(String::length).map(l -> l / 0);

		// using lambdas
		successfulMono.subscribe(
				i -> onNext(i),
				err -> onError(err),
				() -> onComplete()
		);

		// using method references
		erroneousMono.subscribe(
				MonoSubscribeInDetail::onNext,
				MonoSubscribeInDetail::onError,
				MonoSubscribeInDetail::onComplete
		);

	}

	private static void onNext(Object i) {
		logger.log(Level.INFO, "Received item: {}", i);
	}

	private static void onError(Throwable err) {
		logger.log(Level.WARNING, "Error: {}",  err.getMessage());
	}

	private static void onComplete() {
		logger.log(Level.INFO, "Completed");
	}

}
