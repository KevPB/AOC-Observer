package aoc;

import java.util.ArrayList;
import java.util.List;

public class GeneratorImpl implements Generator {

    private Integer value;
    private List<ObserverGeneratorAsync> observerAsyncs;
    //private int checkCount;

    public GeneratorImpl(){
        this.value = 0;
        this.observerAsyncs = new ArrayList<>();
        this.value = 0;
    }

    public Integer getValue(){
    	//this.checkCount++;
        return this.value;
    }

    public void increment(){
    	/*if (checkCount != observerAsyncs.size()) {
    		return;
    	}*/
    	
        this.value++;
        for(ObserverGeneratorAsync channel : observerAsyncs){
            channel.update(this);
        }
        //this.checkCount = 0;
    }



}
