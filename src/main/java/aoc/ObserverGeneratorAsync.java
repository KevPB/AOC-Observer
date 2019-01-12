package aoc;

import java.util.concurrent.Future;

/**
 * Play the role of service in Active Object pattern
 * for the update call
 */
public interface ObserverGeneratorAsync {

    public Future<Void> update(Generator generatorImpl);

}
