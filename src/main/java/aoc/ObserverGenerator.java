package aoc;

/**
 * the observer that would display the generator value
 * Play the role of observer in Observer Pattern
 */
public interface ObserverGenerator {

	public void update(GeneratorAsync subject) throws Exception;
	
}
