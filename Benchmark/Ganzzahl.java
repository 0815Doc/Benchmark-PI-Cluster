
/**
 * Beschreiben Sie hier die Klasse Gz.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ganzzahl extends Benchmark 
{
    long ergebnis = 0;
    
    public Ganzzahl(UI ui)
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
                ergebnis +=  j;
            }
        }        
        stoppeZeit();
    }    
}
