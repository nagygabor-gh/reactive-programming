package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class FluxFromStream {

	private static final Logger logger = Logger.getLogger(FluxFromStream.class.getName());

	public static void main(String[] args) {

		List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = integers.stream();

		Flux<Integer> integerFlux = Flux.fromStream(stream);
		integerFlux.subscribe(ReactiveUtil.onNext());
		// 2nd usage gives an error, since stream can be used only once
		integerFlux.subscribe(i -> logger.info("Subscriber 2 received: " + i), ReactiveUtil.onError(), ReactiveUtil.onComplete());

		// to avoid it, use a stream supplier

		Flux<Integer> integerFluxFromSupplier = Flux.fromStream(integers::stream);
		integerFluxFromSupplier.subscribe(ReactiveUtil.onNext());
		integerFluxFromSupplier.subscribe(i -> logger.info("Subscriber 2 received: " + i), ReactiveUtil.onError(), ReactiveUtil.onComplete());
	}

}
