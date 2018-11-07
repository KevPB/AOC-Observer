package aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Generator {

    private int value;
    private List<ObserverGeneratorAsync> observerAsyncs;

    public Generator(){
        this.value = 0;
        this.observerAsyncs = new ArrayList<>();
    }

    public int getValue(){
        return this.value;
    }

    public void increment(){
        this.value++;
        for(ObserverGeneratorAsync observer : observerAsyncs){
            observer.update(this);
        }
    }



}
