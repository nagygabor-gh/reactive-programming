package com.seniordevlog.reactive.examples.assignment.filereader;

import com.seniordevlog.reactive.examples.ReactiveUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import reactor.core.publisher.Mono;

public class ReactiveFileServiceWithMono {

	private static final Logger logger = Logger.getLogger(ReactiveUtil.class.getName());

	private static final Path PATH = Paths.get("src/main/resources/assignment/filereader");

	public Mono<String> read(String fileName) {
		return Mono.fromSupplier(() -> readFile(PATH + "/" + fileName));
	}

	public Mono<Void> write(String fileName, String content) {
		logger.log(Level.INFO, "writing read4.txt");
		return Mono.fromRunnable(() -> writeFile(fileName, content));
	}

	public Mono<Void> delete(String fileName) {
		logger.log(Level.INFO, "deleting read4.txt");
		return Mono.fromRunnable(() -> deleteFile(fileName));
	}

	private String readFile(String fileName) {
		try {
			return Files.readString(Paths.get(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeFile(String fileName, String content) {
		try {
			Files.writeString(PATH.resolve(fileName), content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void deleteFile(String fileName) {
		try {
			Files.delete(PATH.resolve(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
