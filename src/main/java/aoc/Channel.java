package aoc;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Channel implements ObserverGeneratorAsync, GeneratorAsync {

	private List<ObserverGenerator> displays;
	private ScheduledExecutorService scheduler;
	
	public Channel(ScheduledExecutorService scheduler) {		
		this.scheduler = scheduler;
	}
	
	private long delayGenerator() {
		//TODO
		return 1000;
	}

	@Override
	public Future<Void> update(Generator generator) {
		Update update = new Update(this, display);
		return scheduler.schedule(update, delayGenerator(), TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Integer> getValue() {
		GetValue getValue = new GetValue(generator);
		return scheduler.schedule(getValue, 0, TimeUnit.MILLISECONDS);
	}

	@Override
	public void attach(ObserverGenerator obs) {
		displays.add(obs);		
	}

	@Override
	public void detach(ObserverGenerator obs) {
		displays.remove(obs);
	}
}
