package com.seniordevlog.reactive.examples.mono;

import java.util.logging.Logger;

import reactor.core.publisher.Mono;

public class MonoWithJust {

	private static final Logger logger = Logger.getLogger(MonoWithJust.class.getName());

	public static void main(String[] args) {
		Integer data = 1;
		Mono<Integer> monoWithJust = Mono.just(data);
		monoWithJust.subscribe(
				i -> logger.info("Received item: " + i)
		);
	}

}
