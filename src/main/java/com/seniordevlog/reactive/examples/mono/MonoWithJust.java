package com.seniordevlog.reactive.examples.mono;

import reactor.core.publisher.Mono;

public class MonoWithJust {

	public static void main(String[] args) {
		Integer data = 1;
		Mono<Integer> monoWithJust = Mono.just(data);
		monoWithJust.subscribe(
				i -> System.out.println("Received item: " + i)
		);
	}

}
