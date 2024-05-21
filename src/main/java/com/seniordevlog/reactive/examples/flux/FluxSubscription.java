package com.seniordevlog.reactive.examples.flux;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class FluxSubscription {

	private static final Logger logger = Logger.getLogger(FluxSubscription.class.getName());

	public static void main(String[] args) {
		/**
		  * AtomicReference is a class that provides a way to handle an object reference in a thread-safe manner.
		  * It uses low-level atomic operations provided by the CPU to ensure that updates are done atomically.
		  * 3 key properties:
		  * - Thread Safety: Updates to the reference are atomic, meaning they are done in a single step without interruption.
		  *   This prevents race conditions where multiple threads try to update the reference at the same time.
		  * - Non-blocking: Unlike synchronized blocks or explicit locks, AtomicReference provides a way to update references without blocking other threads.
		  * - Simplicity: It provides a simpler and more readable way to handle atomic updates compared to traditional synchronization mechanisms.
		  */
		AtomicReference<Subscription> subscriptionReference = new AtomicReference<>();

		// if you do not request any items, it will exit without doing anything
		Flux.range(1, 20)
				.log()
				.subscribeWith(new Subscriber<Integer>() {
					@Override
					public void onSubscribe(Subscription subscription) {
						logger.info("Received subscription: " + subscription);
						subscriptionReference.set(subscription);
					}

					@Override
					public void onNext(Integer integer) {
						logger.info("onNext: " + integer);
					}

					@Override
					public void onError(Throwable throwable) {
						logger.info("onError: " + throwable.getMessage());
					}

					@Override
					public void onComplete() {
						logger.info("onComplete");
					}
				});

		ReactiveUtil.sleepSeconds(3);

		subscriptionReference.get().request(3);

		ReactiveUtil.sleepSeconds(5);

		subscriptionReference.get().request(3);

		ReactiveUtil.sleepSeconds(5);

		logger.info("Going to cancel");
		subscriptionReference.get().cancel();

		// After cancelling, no more request can be done! Same after onComplete.
		ReactiveUtil.sleepSeconds(3);

		subscriptionReference.get().request(4);
		ReactiveUtil.sleepSeconds(3);
	}

}
