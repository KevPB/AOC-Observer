package aoc;

import java.util.Observer;
import java.util.concurrent.Future;

public interface ObserverGeneratorAsync extends Observer {

    public Future update(Generator generator);

}
