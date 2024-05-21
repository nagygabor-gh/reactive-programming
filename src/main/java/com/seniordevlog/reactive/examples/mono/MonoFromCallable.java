package com.seniordevlog.reactive.examples.mono;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.concurrent.Callable;

import reactor.core.publisher.Mono;

public class MonoFromCallable {

	public static void main(String[] args) {

		Callable<String> stringCallable = () -> ReactiveUtil.faker().name().fullName();
		Mono<String> stringMono = Mono.fromCallable(stringCallable);
		stringMono.subscribe(ReactiveUtil.onNext());

	}

}
