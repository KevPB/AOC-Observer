package aoc;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

	private Generator generator;
	
	public GetValue(Generator generator) {
		this.generator = generator;
	}

	@Override
	public Integer call() throws Exception {
		return generator.getValue();
	}

}
