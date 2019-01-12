package aoc;

import java.util.concurrent.Future;

/**
 * Concrete implementation of Observer in Observer pattern with channel as subject
 * Will display the generator value
 */
public class Display implements ObserverGenerator {
	
	private Integer value;
	private int id; 
	
	public Display(int id) {
		this.id = id;
		this.value = 0;
	}

    /**
     * Display the value of generator
     * @param g the subject to call getValue
     * @throws Exception : with future handling
     */
	public void update(GeneratorAsync g) throws Exception {
		Future<Integer> future = g.getValue();
		value = future.get();
		System.out.println("Display " + id + ": " + value);
	}

	public Integer getValue() {
		return value;
	}

	
	
}
