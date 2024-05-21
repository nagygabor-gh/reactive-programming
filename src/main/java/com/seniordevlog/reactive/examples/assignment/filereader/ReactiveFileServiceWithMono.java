package com.seniordevlog.reactive.examples.assignment.filereader;

import java.nio.file.Path;
import java.nio.file.Paths;

import reactor.core.publisher.Mono;

public class ReactiveFileServiceWithMono {

	private static final Path PATH = Paths.get("src/main/resources/assignment/filereader");

	public Mono<String> read(String fileName) {
		// TODO implement
		//
		return Mono.empty();
	}

	public Mono<Void> write(String fileName, String content) {
		// TODO implement
		return Mono.empty();
	}

	public Mono<Void> delete(String fileName) {
		// TODO implement
		return Mono.empty();
	}

	private String readFile(String fileName) {
		// TODO implement
		// Files.readString
		return "";
	}

	private void writeFile(String fileName, String content) {
		// TODO implement
		// Files.writeString
	}

	private void deleteFile(String fileName) {
		// TODO implement
		// Files.delete
	}

}
