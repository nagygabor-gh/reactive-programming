package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class FluxInterval {

	public static void main(String[] args) {
		Flux.interval(Duration.ofSeconds(1))
				.subscribe(ReactiveUtil.onNext());
		ReactiveUtil.sleepSeconds(5);
	}

}
