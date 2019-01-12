package aoc;

import java.util.concurrent.Future;

/**
 * Play the role of service in Active Object pattern
 * for the getValue call
 */
public interface GeneratorAsync {
	
	public Future<Integer> getValue();
	
    public void attach(ObserverGenerator obs);
    
    public void detach(ObserverGenerator obs);

}
