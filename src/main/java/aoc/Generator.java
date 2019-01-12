package aoc;

/**
 * Play the role of subject in Observer Pattern
 * Play the role of client in Active Object pattern in update call
 * Play the role of Servant in Active Object pattern in getValue call
 * Interface to handle all necessary method for all these patterns
 */
public interface Generator {

    public Integer getValue(ObserverGeneratorAsync obs);
    
    public Integer getValue();

    public void increment();
    
    public void attach(ObserverGeneratorAsync obs);
    
    public void detach(ObserverGeneratorAsync obs);

}
