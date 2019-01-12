package aoc;

import aoc.Strategy.DiffusionAtomique;
import aoc.Strategy.DiffusionSequentielle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


/**
 * Main class to run the service
 * Generator, display and channel instanciation
 * attach display to channel
 * attach channel to generator
 * Play with corePoolSize in Executors.newScheduledThreadPool
 * Run the generator to start the service
 */
public class App 
{
    public static void main( String[] args )
    {
    	GeneratorImpl generator = new GeneratorImpl(new DiffusionAtomique());
    	ObserverGenerator display1 = new Display(1);
    	ObserverGenerator display2 = new Display(3);
    	ObserverGenerator display3 = new Display(2);
    	ObserverGenerator display4 = new Display(4);
    	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(20);
    	Channel channel1 = new Channel(scheduler);
    	channel1.attach(display1);
    	Channel channel2 = new Channel(scheduler);
    	channel2.attach(display2);
    	Channel channel3 = new Channel(scheduler);
    	channel3.attach(display3);
    	Channel channel4 = new Channel(scheduler);
    	channel4.attach(display4);
    	generator.attach(channel1);
    	generator.attach(channel2);
    	generator.attach(channel3);
    	generator.attach(channel4);
    	generator.run();
    }
}
