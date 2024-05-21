package com.seniordevlog.reactive.examples.mono;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import reactor.core.publisher.Mono;

public class MonoFromSupplier {

	private static final Logger logger = Logger.getLogger(MonoFromSupplier.class.getName());

	public static void main(String[] args) {

		var integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// we can only use just if data is already available!
		wasteCpuCycles(integerList);

		// no unnecessary work
		lazyMono(integerList);

	}

	private static void wasteCpuCycles(List<Integer> integerList) {
		Mono.just(sumIntegers(integerList))
		//		.subscribe(ReactiveUtil.onNext())
		;
	}

	private static void lazyMono(List<Integer> integerList) {
		Mono.fromSupplier(() -> sumIntegers(integerList))
		//		.subscribe(ReactiveUtil.onNext())
		;
	}

	private static int sumIntegers(List<Integer> integerList) {
		logger.log(Level.INFO, "Calculating sum of {0}", integerList);
		return integerList.stream().mapToInt(a -> a).sum();
	}

}
