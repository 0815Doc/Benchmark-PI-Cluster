
/**
 * Beschreiben Sie hier die Klasse Benchmark.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.*;
import java.util.Date;
// import java.time.DateTime;
public class Benchmark
{
    private int anzahlDurchlaeufe;      //Variable der benötigten oder verwendeten Durchläufe
    private Date datum1;                //Startvariable zur Zeitberechnung
    private Date datum2;                //Stopvariable zur Zeitberechnung
    double ergebnisFkz;
    long ergebnisGz;
    
    public Benchmark()
    {
       anzahlDurchlaeufe= 0;   
    }
    
    public void setAnzahlDurchlaeufe(int anzahl)
    {
       this.anzahlDurchlaeufe = anzahl; 
    }
    
    public int getAnzahlDurchlaeufe()
    {
       return anzahlDurchlaeufe; 
    }
    
    public long starteZeit()
    {
        datum1 = new Date();            //Erzeugen eines Date Objektes
        return datum1.getTime();  //Zeitstempel des Dateobjektes in Millisekunden
    }
    
    public long stoppeZeit()
    {
        datum2 = new Date();            //Erzeugen eines Date Objektes
        return datum2.getTime();   //Zeitstempel des Dateobjektes in Millisekunden
    }
    
    public void berechneFkz()
    {
        ergebnisFkz = 0;
        for (int i = 0; i < anzahlDurchlaeufe; i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnisFkz +=  0.123 * j;
            }
        }
    }
    
    public void berechneGz()
    {
        ergebnisGz = 0;
        for (int i = 0; i < anzahlDurchlaeufe; i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnisGz +=  j;
            }
        }
    }
}
