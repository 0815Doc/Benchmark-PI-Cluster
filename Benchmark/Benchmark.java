
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
    private int     anzahlDurchlaeufe;     //Berechnungsiterationen
    private Date    datum1;                //Startvariable zur Zeitberechnung
    private Date    datum2;                //Stopvariable zur Zeitberechnung
    double          ergebnisFkz;
    long            ergebnisGz;
    
    public Benchmark()
    {
       anzahlDurchlaeufe= 0;   
    }
    
    public void setAnzahlDurchlaeufe(int anzahl)
    {
       anzahlDurchlaeufe = anzahl; 
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
    

    public void rechneFkz()
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
    

    public void rechneGz()
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


    public void rechneGz_m()
    {
        Thread thread1 = new Thread(new ThreadGz());
        thread1.start();
        Thread thread2 = new Thread(new ThreadGz());
        thread2.start();
        Thread thread3 = new Thread(new ThreadGz());
        thread3.start();
        
        try 
        {
           thread1.join();
           // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
           System.out.println("Thread1 fertig");
           try 
           {
               thread2.join();
               // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
               System.out.println("Thread2 fertig");
               try 
               {
                   thread3.join();
                   // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
                   System.out.println("Thread3 fertig"); 

                    
               } 
               catch (InterruptedException e) 
               {
                   // Thread wurde abgebrochen
               }
           } 
           catch (InterruptedException e) 
           {
                   // Thread wurde abgebrochen
           }
        } 
        catch (InterruptedException e) 
        {
           // Thread wurde abgebrochen
        }
    }


    public void rechneFkz_m()
    {
       Thread thread1 = new Thread(new ThreadFkz());
        thread1.start();
        Thread thread2 = new Thread(new ThreadFkz());
        thread2.start();
        Thread thread3 = new Thread(new ThreadFkz());
        thread3.start();
        
        try 
        {
           thread1.join();
           // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
           System.out.println("Thread1 fertig");
           try 
           {
               thread2.join();
               // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
               System.out.println("Thread2 fertig");
               try 
               {
                   thread3.join();
                   // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
                   System.out.println("Thread3 fertig"); 
               } 
               catch (InterruptedException e) 
               {
                   // Thread wurde abgebrochen
               }
           } 
           catch (InterruptedException e) 
           {
                   // Thread wurde abgebrochen
           }
        } 
        catch (InterruptedException e) 
        {
           // Thread wurde abgebrochen
        }
    }


    // Zeitmessung Ganzzahl
    public long zeitmessungGz()
    {
        long start = starteZeit();

        rechneGz();

        long stop = stoppeZeit();
        
        return (stop - start);            
    }
    
    
    // Zeitmessung fuer Ganzzahlen multithreaded 
    public long zeitmessungGz_m()
    {
        long start = starteZeit();

        rechneGz_m();

        long stop = stoppeZeit();

        return (stop - start);
    }
    

    // Zeitmessung fuer Fliesskommazahlen multithreaded 
    public long zeitmessungFkz_m()
    {
        long start = starteZeit();

        rechneFkz_m();

        long stop = stoppeZeit();

        return (stop - start);
    }


    // Zeitmessung Fliesskomma
    public long zeitmessungFkz()
    {
        long start = starteZeit();
        
        rechneFkz();

        long stop = stoppeZeit();

        return (stop - start);
    }


    // Ganzzahl-Rechenlast fuer 3 Sekunden Laufzeit ermitteln
    public long lastberechnungGz()
    {
        double  dauer       = 3000;
        int     iterationen = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
        
        setAnzahlDurchlaeufe(iterationen);
        
        double faktor = zeitmessungGz() / dauer;

        return (long)(iterationen / faktor);
    }
    

    // Fliesskomma-Rechenlast fuer 3 Sekunden Laufzeit ermitteln
    public long lastberechnungFkz()
    {
        double  dauer       = 3000;
        int     iterationen = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
        
        setAnzahlDurchlaeufe(iterationen);
        
        double faktor = zeitmessungFkz() / dauer;

        return (long)(iterationen / faktor);
    }
    
    
    // Lastberechnung fuer Ganzzahlen (Multithread)
    public long lastberechnungGz_m()
    {
        double  dauer       = 3000;
        int     iterationen = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
        
        setAnzahlDurchlaeufe(iterationen);
        
        double  faktor = zeitmessungGz_m()/dauer;

        return (long)(iterationen / faktor);
    }
    

    // Lastberechnung fuer Fliesskommazahlen (Multithread)
    public long lastberechnungFkz_m()
    {
        double  dauer       = 3000;
        int     iterationen = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
        
        setAnzahlDurchlaeufe(iterationen);
        
        double faktor = zeitmessungFkz_m() / dauer;

        return (long)(iterationen / faktor);
    }

}
