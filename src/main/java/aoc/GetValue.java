package aoc;

import java.util.concurrent.Callable;

/**
 * Methode invocation GetValue in Active Object pattern
 */
public class GetValue implements Callable<Integer> {

	private Generator generator;
	private ObserverGeneratorAsync observerGeneratorAsync;
	
	public GetValue(Generator generator, ObserverGeneratorAsync observerGeneratorAsync) {
		this.generator = generator;
		this.observerGeneratorAsync = observerGeneratorAsync;
	}

	@Override
	public Integer call() throws Exception {
		return generator.getValue(observerGeneratorAsync);
	}

}