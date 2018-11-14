package aoc;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Channel implements ObserverGeneratorAsync, GeneratorAsync {

	private Generator generator;
	private ObserverGenerator display;
	private ScheduledExecutorService scheduler;
	
	public Channel(Generator generator, ObserverGenerator display, ScheduledExecutorService scheduler) {
		this.generator = generator;
		this.display = display;
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
}
