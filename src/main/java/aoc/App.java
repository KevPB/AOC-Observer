package aoc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	GeneratorImpl generator = new GeneratorImpl();
    	ObserverGenerator display1 = new Display(1);
    	ObserverGenerator display2 = new Display(3);
    	ObserverGenerator display3 = new Display(2);
    	ObserverGenerator display4 = new Display(4);
    	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(8);
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
