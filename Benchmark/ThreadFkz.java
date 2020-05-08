
/**
 * Beschreiben Sie hier die Klasse Fliesskommazahl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ThreadFkz extends Fliesskommazahl_m implements Runnable
{
    double ergebnis = 0;
    @Override
    public void run()
    {
       Thread thread = Thread.currentThread(); 
       rechne(); 
       // for (int i = 0; i < 100000; i++)
        // {
            // for (int j = 0; j < 100000; j++)
            // {
                // ergebnis +=  0.123 * j;
            // }
        // }
    }
    
}
