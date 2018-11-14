package aoc;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {
	
	GeneratorAsync generator;
	ObserverGenerator display;

	public Update(GeneratorAsync generator, ObserverGenerator display) {
		this.generator = generator;
		this.display = display;
	}

	@Override
	public Void call() throws Exception {
		display.update(generator);
		return null;
	}

}
