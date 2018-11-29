package aoc.Strategy;

import aoc.GeneratorImpl;
import aoc.ObserverGenerator;
import aoc.ObserverGeneratorAsync;

public interface AlgoDiffusion {

    void configure();
    void execute(GeneratorImpl generator);
    Integer getValue(ObserverGeneratorAsync observerGeneratorAsync, GeneratorImpl generator);
}
