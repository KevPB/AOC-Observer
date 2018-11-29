package aoc;

import aoc.Strategy.AlgoDiffusion;

import java.util.ArrayList;
import java.util.List;

public class GeneratorImpl implements Generator, Runnable {

    private Integer value;
    private List<ObserverGeneratorAsync> observerAsyncs;
    private AlgoDiffusion algoDiffusion;

    public GeneratorImpl(AlgoDiffusion algoDiffusion){
        this.value = 0;
        this.observerAsyncs = new ArrayList<>();
        this.algoDiffusion = algoDiffusion;
    }

    // Is this too ugly?
    public Integer getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }
    
    public Integer getValue(ObserverGeneratorAsync obs){

        return algoDiffusion.getValue(obs,this);
    }

    public void increment(){
        this.value++;
        System.out.println("Generator: " + this.value);

    }

	@Override
	public void run() {

		while(this.value < 10){

		    try {
		        Thread.sleep(1000);
            } catch (Exception e){}
            algoDiffusion.execute(this);
        }

	}

	@Override
	public void attach(ObserverGeneratorAsync obs) {

		this.observerAsyncs.add(obs);
	}

	@Override
	public void detach(ObserverGeneratorAsync obs) {

		this.observerAsyncs.remove(obs);
	}

    public List<ObserverGeneratorAsync> getObserverAsyncs() {
        return observerAsyncs;
    }

}
