package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import reactor.core.publisher.Flux;

public class FluxWithJust {

	public static void main(String[] args) {
		Flux<Object> fluxWithJust = Flux.just(1, 2, 3, "a", ReactiveUtil.faker().name().fullName());
		fluxWithJust.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
	}

}
