package aoc.Strategy;

import aoc.GeneratorImpl;
import aoc.ObserverGeneratorAsync;
import java.util.ArrayList;
import java.util.List;

/**
 * Atomic diffusion:
 * Generator wait all channel call getValue before incrementation
 */
public class DiffusionAtomique implements AlgoDiffusion {

    /**
     * List of channel that have call getValue
     */
    private List<ObserverGeneratorAsync> readers;

    /**
     * Boolean to state if all channel have call getValue
     */
    private boolean read;

    public DiffusionAtomique(){
        this.readers = new ArrayList<>();
        this.read = true;
    }


    @Override
    public void configure() {
    }

    /**
     * Execute the atomic Algorythme
     * @param generator that increment the value to display
     */
    @Override
    public void execute(GeneratorImpl generator) {
        
        if(this.read){
            this.read = false;
            this.readers.removeAll(this.readers);
            generator.increment();
            for(ObserverGeneratorAsync channel : generator.getObserverAsyncs()) {
                channel.update(generator);
            }
        }

    }

    /**
     *
     * @param observerGeneratorAsync the channel that call getValue
     * @param generator that increment the value to display
     * @return the generator value
     */
    @Override
    public Integer getValue(ObserverGeneratorAsync observerGeneratorAsync, GeneratorImpl generator) {

        if (!this.readers.contains(observerGeneratorAsync)){
            this.readers.add(observerGeneratorAsync);
            if (this.readers.size() == generator.getObserverAsyncs().size()) {
                this.read = true;
            }
        }

        return generator.getValue();
    }
}
