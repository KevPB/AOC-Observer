package aoc;

import java.util.concurrent.Future;

public interface ObserverGeneratorAsync {

    public Future<Void> update(Generator generatorImpl);

}
