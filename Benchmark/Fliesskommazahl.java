
/**
 * Beschreiben Sie hier die Klasse Flie�kommazahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fliesskommazahl extends Benchmark
{
   double ergebnis1 = 0;
   double ergebnis2 = 0;
   
   public Fliesskommazahl()
   {
        getAnzahlDurchlaeufe();
   }
    
   public void berechneFkz()
    {
        for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        {
            ergebnis1 +=  0.123 * i;
            for (int j = 0; j < 100000; j++)
            {
                ergebnis2 +=  0.123 * j;
            }
        }
        // System.out.println("Ergebnis1: "+ ergebnis1);
        // System.out.println("Ergebnis2: "+ ergebnis2);
        // try {Thread.sleep(1000); } catch(Exception ex) { /* !! DOUH !! */ }
    } 
}
