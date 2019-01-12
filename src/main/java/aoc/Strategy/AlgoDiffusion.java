package aoc.Strategy;

import aoc.GeneratorImpl;
import aoc.ObserverGeneratorAsync;

/**
 * Strategy Pattern to handle 3 types of diffusion
 * - Atomique
 * - Sequential
 * - Causale
 */
public interface AlgoDiffusion {

    /**
     * configure the algorythme but not used in this project
     */
    void configure();

    /**
     * Execute the algorythme
     * @param generator that increment the value to display
     */
    void execute(GeneratorImpl generator);

    /**
     * We add this method to handle which chanel request the getValue
     * @param observerGeneratorAsync the channel that call getValue
     * @param generator that increment the value to display
     * @return the generator value
     */
    Integer getValue(ObserverGeneratorAsync observerGeneratorAsync, GeneratorImpl generator);
}
