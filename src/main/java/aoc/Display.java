package aoc;

import java.util.concurrent.Future;

public class Display implements ObserverGenerator {
	
	private Integer value;
	
	public Display() {
		this.value = 0;
	}

	public void update(GeneratorAsync g) throws Exception {
		// TODO : Get Value Phase
		Future<Integer> future = g.getValue();
	}

	public Integer getValue() {
		return value;
	}

	
	
}
