package aoc;

public interface Generator {

    public Integer getValue(ObserverGeneratorAsync obs);

    public void increment();
    
    public void attach(ObserverGeneratorAsync obs);
    
    public void detach(ObserverGeneratorAsync obs);

}
