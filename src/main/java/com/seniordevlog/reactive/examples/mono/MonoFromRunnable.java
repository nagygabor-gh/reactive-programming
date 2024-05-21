package com.seniordevlog.reactive.examples.mono;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.concurrent.Callable;

import reactor.core.publisher.Mono;

public class MonoFromRunnable {

	public static void main(String[] args) {

		Runnable runnable = () -> System.out.println("Hello World");
		Mono.fromRunnable(runnable)
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
		Mono.fromRunnable(timeConsumingProcess())
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), () -> System.out.println("Process is done, sending message ..."));
	}

	private static Runnable timeConsumingProcess() {
		return () -> {
			ReactiveUtil.sleepSeconds(3);
			System.out.println("Operation completed");
		};
	}

}
