
/**
 * Beschreiben Sie hier die Klasse Ganzzahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ganzzahl extends Benchmark
{
    long ergebnis1 = 0;
    long ergebnis2 = 0;
        
    public Ganzzahl()
    {
        getAnzahlDurchlaeufe();        
    }
    
    public void berechneGz()
    {
        for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        {
            ergebnis1 +=  i;
            for (int j = 0; j < 100000; j++)
            {
                ergebnis2 +=  j;
            }
        }
        // System.out.println("Ergebnis1: "+ ergebnis1);
        // System.out.println("Ergebnis2: "+ ergebnis2);
        // try {Thread.sleep(1000); } catch(Exception ex) { /* !! DOUH !! */ }
    }
}
