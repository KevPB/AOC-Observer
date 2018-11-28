package aoc;

import java.util.List;
import java.util.concurrent.Callable;

public class Update implements Callable<Void> {
	
	private GeneratorAsync generator;
	private List<ObserverGenerator> displays;

	public Update(GeneratorAsync generator, List<ObserverGenerator> displays) {
		this.generator = generator;
		this.displays = displays;
	}

	@Override
	public Void call() throws Exception {
		if (displays.size() > 0) {
			for (ObserverGenerator display : displays) {
				display.update(generator);
			}	
		}
		return null;
	}

}
