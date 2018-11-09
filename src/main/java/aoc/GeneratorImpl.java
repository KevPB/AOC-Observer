package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class GeneratorImpl implements Generator {

    private Integer value;
    private List<ObserverGeneratorAsync> observerAsyncs;

    public GeneratorImpl(){
        this.value = 0;
        this.observerAsyncs = new ArrayList<>();
    }

    public Integer getValue(){
        return this.value;
    }

    public void increment(){
        this.value++;
        for(ObserverGeneratorAsync observer : observerAsyncs){
            observer.update(this);
        }
    }



}
