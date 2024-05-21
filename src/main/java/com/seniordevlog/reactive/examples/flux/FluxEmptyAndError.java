package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import reactor.core.publisher.Flux;

public class FluxEmptyAndError {

	public static void main(String[] args) {
		Flux<Object> emptyFlux = Flux.empty();
		emptyFlux.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());

		Flux<Object> erroneousFlux = Flux.error(() -> new NullPointerException("NPE"));
		erroneousFlux.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
	}

}
