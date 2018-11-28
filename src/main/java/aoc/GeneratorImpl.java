package aoc;

import java.util.ArrayList;
import java.util.List;

public class GeneratorImpl implements Generator, Runnable {

    private Integer value;
    private List<ObserverGeneratorAsync> observerAsyncs;
    //private int checkCount;

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
    	//this.checkCount++; TODO : check if every observer has called this method
        return this.getValue();
    }

    public void increment(){
    	/*if (checkCount != observerAsyncs.size()) {
    		return;
    	}*/
    	
        this.value++;
        System.out.println("Generator: " + value);
        for(ObserverGeneratorAsync channel : observerAsyncs){
            channel.update(this);
        }
        //this.checkCount = 0;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Start Generator");
		
		for (int i = 0;i < 10; i++) {
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
		// TODO Auto-generated method stub
		this.observerAsyncs.add(obs);
	}

	@Override
	public void detach(ObserverGeneratorAsync obs) {
		// TODO Auto-generated method stub
		this.observerAsyncs.remove(obs);
	}



}
