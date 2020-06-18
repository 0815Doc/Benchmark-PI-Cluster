
/**
 * Beschreiben Sie hier die Klasse Fliesskommazahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fliesskommazahl extends Benchmark
{
    private double ergebnis;
    
    public Fliesskommazahl(UI ui)
    {
        super(ui);
    }
    
    public void rechne()
    {
        ergebnis = 0;
        starteZeit();
        for (int i = 0; i < ui.getAnzahlDurchlaeufe(); i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  0.123 * j;
            }
        }
        stoppeZeit();
        
    }
}
