package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import reactor.core.publisher.Flux;

public class FluxToMono {

	public static void main(String[] args) {
		// get the first element only
		Flux.range(1, 10)
				.next()
				.subscribe(ReactiveUtil.onNext());

		// apply filtering
		Flux.range(1, 10)
				.filter(i -> i > 3)
				.next()
				.subscribe(ReactiveUtil.onNext());
	}

}
