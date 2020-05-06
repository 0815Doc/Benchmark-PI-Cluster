
/**
 * Beschreiben Sie hier die Klasse Ganzzahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class ThreadGz extends Benchmark implements Runnable//implements run??
{
    long ergebnis = 0;
    // Benchmark b = new Benchmark();
    
    @Override
    public void run()
    {
       Thread thread = Thread.currentThread(); 
       // berechneGz();
       for (int i = 0; i < 100000; i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  j;
            }
        } 
       // System.out.println(ergebnis);
    }
    
    
}
