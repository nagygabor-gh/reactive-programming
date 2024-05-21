package com.seniordevlog.reactive.examples.mono;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.concurrent.CompletableFuture;

import reactor.core.publisher.Mono;

public class MonoFromFuture {

	public static void main(String[] args) {
		Mono<String> stringMono = Mono.fromFuture(getNameInFuture());
		stringMono.subscribe(ReactiveUtil.onNext());
		// without this we are not seeing the result because it is executed as part of the fork join pool, basically another thread -> we need to block the main thread
		//ReactiveUtil.sleepSeconds(1);
	}

	private static CompletableFuture<String> getNameInFuture() {
		return CompletableFuture.supplyAsync(() -> ReactiveUtil.faker().name().fullName());
	}

}
