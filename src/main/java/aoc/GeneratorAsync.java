package aoc;

import java.util.concurrent.Future;

public interface GeneratorAsync {
	
	public Future<Integer> getValue();
	
    public void attach(ObserverGenerator obs);
    
    public void detach(ObserverGenerator obs);

}
