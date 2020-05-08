
/**
 * Beschreiben Sie hier die Klasse Fliesskommazahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fliesskommazahl extends Benchmark
{
    public Fliesskommazahl()
    {
        super();
    }
    
    public void rechne()
    {
        ergebnisFkz = 0;
        for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnisFkz +=  0.123 * j;
            }
        }
    }
}
