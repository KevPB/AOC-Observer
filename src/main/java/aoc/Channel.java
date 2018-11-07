package aoc;

import java.util.Observable;
import java.util.concurrent.Future;

public class Channel implements ObserverGeneratorAsync {
	
	private Display display;

	@Override
	public Future update(Generator generator) {
		return null;
	}
}
