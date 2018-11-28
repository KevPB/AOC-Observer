package aoc;

import java.util.concurrent.Future;

public class Display implements ObserverGenerator {
	
	private Integer value;
	private int id; 
	
	public Display(int id) {
		this.id = id;
		this.value = 0;
	}

	public void update(GeneratorAsync g) throws Exception {
		Future<Integer> future = g.getValue();
		value = future.get();
		System.out.println("Display " + id + ": " + value);
	}

	public Integer getValue() {
		return value;
	}

	
	
}
