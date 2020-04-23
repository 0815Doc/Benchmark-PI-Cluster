
/**
 * Beschreiben Sie hier die Klasse Ganzzahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Ganzzahl extends Benchmark
{
    long ergebnis = 0;
    
    public void berechneGz()
    {
        for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  j;
            }
        }
        // System.out.println("Ergebnis1: "+ ergebnis);
        // try {Thread.sleep(1000); } catch(Exception ex) { /* !! DOUH !! */ }
    }
}
