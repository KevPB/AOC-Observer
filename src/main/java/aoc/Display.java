package aoc;

import java.util.concurrent.Future;

public class Display implements ObserverGenerator {
	
	private Integer value;
	
	public Display() {
		this.value = 0;
	}

	public void update(GeneratorAsync g) throws Exception {
		Future<Integer> future = g.getValue();
		value = future.get();
	}

	public Integer getValue() {
		return value;
	}

	
	
}
