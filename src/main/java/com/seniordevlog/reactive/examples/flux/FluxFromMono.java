package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

	public static void main(String[] args) {
		Mono<String> stringMono = Mono.just("Hello World!");
		// convert mono to flux
		Flux<String> stringFlux = Flux.from(stringMono);
		stringFlux.subscribe(ReactiveUtil.onNext());
	}

}
