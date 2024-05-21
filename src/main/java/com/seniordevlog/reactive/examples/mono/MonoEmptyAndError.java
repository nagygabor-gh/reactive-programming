package com.seniordevlog.reactive.examples.mono;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import reactor.core.publisher.Mono;

public class MonoEmptyAndError {

	public static void main(String[] args) {
		// TODO
		/* Subscribe to the mono to get each case:
		 * - a name
		 * - an empty response
		 * - an error
		 */
	}

	private static Mono<String> getUserNameById(int userId) {
		return switch (userId) {
			case 1 -> Mono.just(ReactiveUtil.faker().name().fullName());
			case 2 -> Mono.empty();
			default -> Mono.error(new RuntimeException("Internal error while searching for user."));
		};
	}

}
