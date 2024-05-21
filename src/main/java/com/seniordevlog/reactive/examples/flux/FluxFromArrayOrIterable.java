package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class FluxFromArrayOrIterable {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c");
		Flux.fromIterable(list).subscribe(ReactiveUtil.onNext());

		Integer[] integerArray = {2,5,7,8};
		Flux.fromArray(integerArray).subscribe(ReactiveUtil.onNext());
	}

}
