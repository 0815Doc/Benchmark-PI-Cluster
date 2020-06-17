
/**
 * Beschreiben Sie hier die Klasse Benchmark.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.*;
import java.util.Date;
// import java.time.DateTime;

public abstract class Benchmark
{
    protected int     anzahlDurchlaeufe;     //Berechnungsiterationen
    protected int     anzahlThreads;         //Anzahl der verwendeten Threads
    protected UI ui;
    
    private static long gestoppteZeit;
    private static long endzeit;
    private static long startzeit;
        
    public Benchmark(UI ui)
    {
       anzahlDurchlaeufe    = 0; 
       anzahlThreads        = 0;
       this.ui = ui;
    }
    
    public abstract void rechne();
    
    
    public static void starteZeit()
    {
        startzeit = System.currentTimeMillis();
    }
        
    public static void stoppeZeit()
    {
        endzeit = System.currentTimeMillis();
        gestoppteZeit = endzeit - startzeit;
    }
   
    public long getGestoppteZeit()
    {
        return gestoppteZeit;
    }
        
    // Zeitmessung 
    public long zeitmessung()
    {
        return (endzeit - startzeit);            
    }
       
}
