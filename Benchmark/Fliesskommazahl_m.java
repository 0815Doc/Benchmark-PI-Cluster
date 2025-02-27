
/**
 * Beschreiben Sie hier die Klasse Fliesskommazahl_m.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fliesskommazahl_m extends Benchmark implements Runnable
{
    private long ergebnis;
    private int threadIndex;
    
    public Fliesskommazahl_m(UI ui, int k)
    {
        super(ui);
        threadIndex = k;
    }
    
    @Override
    public void run()
    {    
        int anzahlT = ui.getAnzahlThreads();
        int anzahl = ui.getAnzahlDurchlaeufe()/anzahlT;
        int temp = 0;       
        
        for (int i = 0; i < anzahl; i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  0.123 * j;
            }
        }
        
        ui.setThreadStatus(threadIndex, true);
        
        for(int i=0 ; i < anzahlT;i++)
        {
            
            if (!ui.getThreadStatus(i))
            {                
                break;
            } 
            temp++; //temp wird nur erhöht, wenn Thread abgeschlossen!
        }
        
        // Wenn alle Threads abgeschlossen wird die Zeit gestoppt 
        if ( temp == anzahlT)      
        {
            stoppeZeit();
            // double tmp = zeitmessung()/1000.; 
            double tmp = getGestoppteZeit()/1000.;
            ui.setGestoppteZeit(tmp);
            System.out.println("     Benoetigte Zeit zur Berechnung: "+ tmp + " Sekunden.");
            System.out.println("     Multithread Rechenleistung: "+ ui.gerundet.format(ui.getAnzahlDurchlaeufe()/tmp) + " FOPS.");
        }
        
        // System.out.println();
    }
    
    public void rechne()
    {
        int anzahlT =  ui.getAnzahlThreads();
        Thread[] threads = new Thread[anzahlT];
        boolean[] status = new boolean[anzahlT];
        
        starteZeit();
       
        for (int k = 0 ; k < anzahlT; k++)
        {
            threads[k] = new Thread(new Fliesskommazahl_m(ui, k));            
            threads[k].start();                       
        }           
    }
}

