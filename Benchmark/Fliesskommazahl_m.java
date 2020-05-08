
/**
 * Beschreiben Sie hier die Klasse Fliesskommazahl_m.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fliesskommazahl_m extends Fliesskommazahl
{
    public void rechne()
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
}
