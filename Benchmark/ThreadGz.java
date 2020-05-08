
/**
 * Beschreiben Sie hier die Klasse Ganzzahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class ThreadGz extends Ganzzahl implements Runnable//implements run??
{
    long ergebnis = 0;
    // Benchmark b = new Benchmark();
    // Ganzzahl g = new Ganzzahl();
    @Override
    public void run()
    {    
       Thread thread = Thread.currentThread(); 
       // for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        // {
            // for (int j = 0; j < 100000; j++)
            // {
                // ergebnis +=  j;
            // }
        // } 
       berechnung();
       System.out.println(thread.getName() + " beendet"); 
       // System.out.println(ergebnis +"+"+ getAnzahlDurchlaeufe());
       // setThreadbeendet(1);
    }
    
    
}
