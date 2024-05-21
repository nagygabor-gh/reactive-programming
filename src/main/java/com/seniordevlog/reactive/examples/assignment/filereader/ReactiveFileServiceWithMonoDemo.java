package com.seniordevlog.reactive.examples.assignment.filereader;

import com.seniordevlog.reactive.examples.ReactiveUtil;

public class ReactiveFileServiceWithMonoDemo {

	public static void main(String[] args) {

		ReactiveFileServiceWithMono fileService = new ReactiveFileServiceWithMono();

		fileService.read("read1.txt")
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
		fileService.read("read2.txt")
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
		// There is no such file as read3.txt!
		fileService.read("read3.txt")
				.subscribe(ReactiveUtil.onNext(), ReactiveUtil.onError(), ReactiveUtil.onComplete());
		// Hint: when is the file created?
		fileService.write("read4.txt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		// Hint: when is the file deleted?
		fileService.delete("read4.txt");
	}

}
