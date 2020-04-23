
/**
 * Beschreiben Sie hier die Klasse Fliesskommazahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fliesskommazahl extends Benchmark
{
   double ergebnis = 0;
       
   public void berechneFkz()
    {
        for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  0.123 * j;
            }
        }
        // System.out.println("Ergebnis1: "+ ergebnis1);
        // System.out.println("Ergebnis2: "+ ergebnis2);
        // try {Thread.sleep(1000); } catch(Exception ex) { /* !! DOUH !! */ }
    } 
}
