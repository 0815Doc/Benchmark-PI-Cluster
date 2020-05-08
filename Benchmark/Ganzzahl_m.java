
/**
 * Beschreiben Sie hier die Klasse Ganzzahl_m.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ganzzahl_m extends Ganzzahl
{
    public void rechne()
    {
        for (int i = 1 ; i <= getAnzahlThreads(); i++)
        {
            Thread thread = new Thread(new ThreadGz());
            thread.setName("Thread" + i);
            thread.start();
            System.out.println(thread.getName() + " gestartet");
            
        }
        // try 
               // {
                   // thread.join();
                   // // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
                   // System.out.println(thread.getName() + " fertig"); 

                    
               // } 
               // catch (InterruptedException e) 
               // {
                   // // Thread wurde abgebrochen
               // }
        // Thread thread2 = new Thread(new ThreadGz());
        // thread2.start();
        // Thread thread3 = new Thread(new ThreadGz());
        // thread3.start();
        
        // try 
        // {
           // thread1.join();
           // // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
           // System.out.println("Thread1 fertig");
           // try 
           // {
               // thread2.join();
               // // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
               // System.out.println("Thread2 fertig");
               // try 
               // {
                   // thread3.join();
                   // // Code der hier steht wird abgearbeitet, wenn der Thread fertig ist.
                   // System.out.println("Thread3 fertig"); 

                    
               // } 
               // catch (InterruptedException e) 
               // {
                   // // Thread wurde abgebrochen
               // }
           // } 
           // catch (InterruptedException e) 
           // {
                   // // Thread wurde abgebrochen
           // }
        // } 
        // catch (InterruptedException e) 
        // {
           // // Thread wurde abgebrochen
        // }
    }
}
