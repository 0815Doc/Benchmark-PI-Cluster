
/**
 * Beschreiben Sie hier die Klasse Gz.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ganzzahl extends Benchmark
{
    long ergebnis = 0;
    
    public Ganzzahl()
    {
        super(); 
        
        
    }
    
    public void rechne()
    {
                        
            for (int i = 1 ; i <= getAnzahlThreads(); i++)
            {
                Thread thread = new Thread(new ThreadGz());
                thread.setName("Thread" + i);
                thread.start();
                System.out.println(thread.getName() + " gestartet");
                try 
               {
                   thread.join();
                   // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
                   // System.out.println(thread.getName() + " fertig");                     
               } 
               catch (InterruptedException e) 
               {
                   // Thread wurde abgebrochen
               }
                
            }
          // {
        // ergebnisGz = 0;
        // for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        // {
            // for (int j = 0; j < 100000; j++)
            // {
                // ergebnisGz +=  j;
            // }
        // }
    }
    
    public void berechnung()
    {
        for (int i = 0; i < getAnzahlDurchlaeufe(); i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  j;
            }
        } 
        System.out.println(ergebnis +"+"+ getAnzahlDurchlaeufe());
    }
    
}
