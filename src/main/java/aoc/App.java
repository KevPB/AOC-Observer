package aoc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Generator Start" );
        GeneratorImpl generator = new GeneratorImpl();
        Thread thread = new Thread(generator);
        thread.run();
    }
}
