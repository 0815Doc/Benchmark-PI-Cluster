
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
        
        for (int i = 0; i < ui.getAnzahlDurchlaeufe(); i++)
        {
            for (int j = 0; j < 100000; j++)
            {
                ergebnis +=  0.123 * j;
            }
        }
        
        ui.setThreadStatus(threadIndex, true);
        System.out.println("Thread"+ name + " beendet:"+ ergebnis +" + "+ anzahl);
        System.out.print("Status "+ threadIndex + " ");
        
        for(int i=0 ; i < anzahlT;i++)
        {
            
            if ( !ui.getThreadStatus(i))
            {                
                break;
            } 
            temp++;
        }
        
        if ( temp == anzahlT)      
        {
            System.out.print("erledigt");
            stoppeZeit();
        }
        System.out.println();
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

