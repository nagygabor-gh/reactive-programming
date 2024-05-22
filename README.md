# Reactive Programming basics

## Quiz

First check these:

 - ```Basic interfaces```
 - ```Backpressure```
 - ```MonoAndFlux-basics```

## Ordering

Mono examples:
```
com.seniordevlog.reactive.examples.mono.MonoWithJust
com.seniordevlog.reactive.examples.mono.MonoSubscribeInDetail
com.seniordevlog.reactive.examples.mono.MonoEmptyAndError
com.seniordevlog.reactive.examples.mono.MonoFromSupplier
com.seniordevlog.reactive.examples.mono.MonoFromRunnable
com.seniordevlog.reactive.examples.mono.MonoFromCallable
com.seniordevlog.reactive.examples.mono.MonoFromFuture
```
Flux examples:
```
com.seniordevlog.reactive.examples.flux.FluxWithJust
com.seniordevlog.reactive.examples.flux.FluxEmptyAndError
com.seniordevlog.reactive.examples.flux.FluxFromMono
com.seniordevlog.reactive.examples.flux.FluxFromArrayOrIterable
com.seniordevlog.reactive.examples.flux.FluxFromStream
com.seniordevlog.reactive.examples.flux.FluxSubscription
com.seniordevlog.reactive.examples.flux.FluxRange
com.seniordevlog.reactive.examples.flux.FluxInterval
com.seniordevlog.reactive.examples.flux.FluxToMono
```

## Assignment

Create a file service using reactive programming. You can run the demo by executing 
```com.seniordevlog.reactive.examples.assignment.filereader.ReactiveFileServiceWithMonoDemo```.
The code in ```ReactiveFileServiceWithMono``` must be implemented first though.

The aim is to read 
 - the 2 files in ```resources/assignment/filereader```
 - read a non-existent file and see how error is handled
 - create a new file
 - delete the created new file