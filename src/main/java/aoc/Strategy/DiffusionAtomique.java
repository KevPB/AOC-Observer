package aoc.Strategy;

import aoc.GeneratorImpl;
import aoc.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;

public class DiffusionAtomique implements AlgoDiffusion {

    private List<ObserverGeneratorAsync> readers;
    private boolean read;

    public DiffusionAtomique(){
        this.readers = new ArrayList<>();
        this.read = true;

    }


    @Override
    public void configure() {
    }

    @Override
    public void execute(GeneratorImpl generator) {
        
        if(this.read){
            generator.increment();
            for(ObserverGeneratorAsync channel : generator.getObserverAsyncs()){
                channel.update(generator);
            }
            this.read = false;
            this.readers.removeAll(this.readers);
        }

    }

    @Override
    public Integer getValue(ObserverGeneratorAsync observerGeneratorAsync, GeneratorImpl generator) {

        if (!this.readers.contains(observerGeneratorAsync)){
            this.readers.add(observerGeneratorAsync);
            if (this.readers.size() == generator.getObserverAsyncs().size()){
                this.read = true;
            }
        }

        return generator.getValue();
    }
}
