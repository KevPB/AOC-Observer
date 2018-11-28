package aoc;

import java.util.ArrayList;
import java.util.List;

public class GeneratorImpl implements Generator, Runnable {

    private Integer value;
    private List<ObserverGeneratorAsync> observerAsyncs;

    public GeneratorImpl(){
        this.value = 0;
        this.observerAsyncs = new ArrayList<>();
        this.value = 0;
    }

    // Is this too ugly?
    public Integer getValue(){
        return this.value;
    }    
    
    public Integer getValue(ObserverGeneratorAsync obs){

        return this.value;
    }

    public void increment(){
        this.value++;
        System.out.println("Generator: " + value);
        for(ObserverGeneratorAsync channel : observerAsyncs){
            channel.update(this);
        }
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Start Generator");
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			this.increment();
		}
		return;
	}

	@Override
	public void attach(ObserverGeneratorAsync obs) {

		this.observerAsyncs.add(obs);
	}

	@Override
	public void detach(ObserverGeneratorAsync obs) {

		this.observerAsyncs.remove(obs);
	}



}
