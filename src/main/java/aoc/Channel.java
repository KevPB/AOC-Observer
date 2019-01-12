package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Implementation of ObserverGeneratorAsync and GeneratorAsync interface
 * Play the role of Proxy in Active Object Pattern
 * Play the role of Observer in Observer pattern with the generator as Subject
 * Play the role of Subject in Observer pattern with the displays as Observers
 *
 * It the mediator between generator and Display,
 * here is the instanciation of Methode Invocation GetValue and Update
 * and the scheduling with random delay value
 */
public class Channel implements ObserverGeneratorAsync, GeneratorAsync {

	/**
	 * displays: list of Observer display
	 * Here we have only one display per channel but we guess
	 * it would be reliable to allow X displays per channel in the future
	 * scheduler: handle the execution of Callable GetValue and Update
	 * generator: target to call getValue
	 */
	private List<ObserverGenerator> displays;
	private ScheduledExecutorService scheduler;
	private Generator generator;
	
	public Channel(ScheduledExecutorService scheduler) {		
		this.scheduler = scheduler;
		this.displays = new ArrayList<ObserverGenerator>();
	}

	/**
	 * Generation of random delay for scheduled Callable
	 * @return
	 */
	private long delayGenerator() {
		return 100 + ((long) (1900 * Math.random()));
	}

	/**
	 * Instanciation of Update Methode Invocation in Active Object pattern for update call
	 * @param generator to put in ref fo update call
	 * @return Future to dispose to the generator, Void means that no returned value is waited
	 */
	@Override
	public Future<Void> update(Generator generator) {
		Update update = new Update(this, displays);
		this.generator = generator;
		return scheduler.schedule(update, delayGenerator(), TimeUnit.MILLISECONDS);
	}

	/**
	 * Instanciation of GetValue Methode Invocation in Active Object pattern for getValue call
	 *
	 * @return a Future that will contain the value of generator after Callable execution
	 */
	@Override
	public Future<Integer> getValue() {
		GetValue getValue = new GetValue(this.generator,this);
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
