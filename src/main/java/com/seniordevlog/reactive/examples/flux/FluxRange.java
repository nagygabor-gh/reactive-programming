package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import reactor.core.publisher.Flux;

public class FluxRange {

	public static void main(String[] args) {
		Flux<Integer> range = Flux.range(1, 10);
		range.log() // logs inner stuff like events, useful for debugging
				.map(i -> ReactiveUtil.faker().name().fullName())
				.subscribe(ReactiveUtil.onNext());
	}

}
