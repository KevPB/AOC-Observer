package aoc;

import java.util.Observer;
import java.util.concurrent.Future;

public interface ObserverGeneratorAsync {

    public Future update(Generator generatorImpl);

}
