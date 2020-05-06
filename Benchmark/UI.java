                            
/**
 * Beschreiben Sie hier die Klasse TestUI.
 * 
 * @author (Michael Schneider) 
 * @version (1)
 */

import java.util.Scanner;
                        
public class UI
{
    Benchmark b = new Benchmark();
    int wert =  0;
        
    public void start()
    {
        int fall = -1;
        boolean exit = false;
        Scanner einlesen = new Scanner(System.in);
            
        while(!exit)
        {
            hauptmenu();
            fall = -1;

            System.out.print("\n Eingabe: ");

            while(fall < 0 || fall > 6)
            {
                // Benutzereingabe 
                if (einlesen.hasNextInt())
                    fall = einlesen.nextInt(); 
            }
                        
            switch(fall)
            {
                case 0: 
                 // Bildschirm leeren
                   System.out.print('\u000C');
                   exit = true;
                   break;
        
                case 1: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("1 Zeitmessung Ganzzahl"); 
                    System.out.println("-----------------------");
                    // ohne print (ohne "ln"), damit der eingegebene Wert hinter dem Text erscheint
                    System.out.print("\n Anzahl der Durchlaeufe? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                        
                    System.out.println("\n Test laeuft...");
                    b.setAnzahlDurchlaeufe(wert);
                        
                    System.out.println(" Benoetigte Zeit zur Berechnung: "+ zeitmessungGz(b)/1000 + " Sekunden");
                    
                    System.out.println("\n\n -----------------------");
                    System.out.println("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                    einlesen.nextInt();
                break;
    
                case 2:
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("2 Zeitmessung Fliesskommazahl"); 
                    System.out.println("-----------------------");
                    // ohne print (ohne "ln"), damit der eingegebene Wert hinter dem Text erscheint
                    System.out.print("\n Anzahl der Durchlaeufe? => ");
                    if (einlesen.hasNextInt())
                    wert = einlesen.nextInt();
                
                    System.out.println("\n Test laeuft...");
                    b.setAnzahlDurchlaeufe(wert);
                
                    System.out.println("Benoetigte Zeit zur Berechnung: "+ zeitmessungFkz(b)/1000 + " Sekunden");
                 
                    System.out.println("\n\n -----------------------");
                    System.out.println("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
    
                case 3: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("3 Lastberechnung Ganzzahl"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten");// jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                      
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)lastberechnungGz(b));
                    System.out.println("\n\n -----------------------");
        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
            
                case 4: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("4 Lastberechnung Fliesskommazahl"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten"); // jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
             
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)lastberechnungFkz(b));
                    System.out.println("\n\n -----------------------");
        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
                
                case 5: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("5 Lastberechnung MultiGanzzahl"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten");// jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)lastberechnungMtGz(b));
                    
                    System.out.println("\n\n -----------------------");
        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
                
                case 6: 
                   
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("6 Lastberechnung MultiFliesskomma"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten");// jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)lastberechnungMtFkz(b));
                    
                    System.out.println("\n\n -----------------------");
        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
            }      
        }
    }
    
    public static void main(String[] args)
    {
        UI emil = new UI();
        emil.start();
    }
    
    // Programmpause in Millisekunden
    public void pause(int dauer)
    {
        try { 
            Thread.sleep( dauer );
        } catch(Exception e) {}
    }

    // diese Methode erzeugt das Hauptmenu
    public void hauptmenu()
    {
        System.out.print('\u000C'); // Bildschirm leeren
        
        System.out.println("========================================="); 
        System.out.println("Hauptmenu"); 
        System.out.println("---------"); 
        System.out.println("\n  Zeitmessung (Laufzeit fuer X Durchlaeufe ermitteln)"); 
        System.out.println("    < 1 > Ganzzahl ");
        System.out.println("    < 2 > Fliesskomma");

        System.out.println("\n  Lastberechnung (benoetigte Durchlaeufe fuer 3 Sekunden Laufzeit ermitteln)"); 
        System.out.println("    < 3 > Ganzahl");
        System.out.println("    < 4 > Fliesskomma");
        System.out.println("    < 5 > MultiGanzahl");
        System.out.println("    < 6 > MultiFliesskomma");
        System.out.println("\n    < 0 > Programm beenden");
        System.out.println("========================================="); 
        
    }
    
    public double zeitmessungGz(Benchmark b)
    {
        long startGz = b.starteZeit();
        b.berechneGz();
        long stopGz = b.stoppeZeit();
        double zeitGz = stopGz - startGz;
        return zeitGz;            
    }
    
    //diese Methode fuehrt die Zeitmessung für Ganzzahlen durch
    public double zeitmessungMtGz(Benchmark b)
    {
        double zeitGz = 0;
        long startGz = b.starteZeit();
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
                   long stopGz = b.stoppeZeit();
                   zeitGz = stopGz - startGz;
                   System.out.println(" Zeit" + zeitGz);
                    
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
        return zeitGz;
    }
     
    // diese Methode fuehrt die Zeitmessung für Fliesskommazahlen durch
    public double zeitmessungFkz(Benchmark b)
    {
        long startFkz = b.starteZeit();
        b.berechneFkz();
        long stopFkz = b.stoppeZeit();
        double zeitFkz = stopFkz - startFkz;
        return zeitFkz;
    }
    
    // diese Methode fuehrt die Zeitmessung für Multithread Fliesskommazahlen durch
    public double zeitmessungMtFkz(Benchmark b)
    {
        double zeitFkz = 0;
        long startFkz = b.starteZeit();
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
                   long stopFkz = b.stoppeZeit();
                   zeitFkz = stopFkz - startFkz;
                   System.out.println(" Zeit" + zeitFkz);  
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
        return zeitFkz;
    }
    
    //diese Methode fuehrt die Lastberechnung für Ganzzahlen durch
    public double lastberechnungGz(Benchmark b)
    {
        int dauerGz = 3000;
        System.out.println("\n Lastberechnung fuer " + dauerGz + "ms laeuft...");
        
        wert = 100000;
        b.setAnzahlDurchlaeufe(wert);
        
        double faktorGz = zeitmessungGz(b)/dauerGz;
        double dlNeuGz = wert / faktorGz;
        // System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)dlNeuGz);
        return dlNeuGz;
    }
    
    //diese Methode fuehrt die Lastberechnung für Ganzzahlen (Multithread) durch
    public double lastberechnungMtGz(Benchmark b)
    {
        int dauerGz = 3000;
        System.out.println("\n Lastberechnung fuer " + dauerGz + "ms laeuft...");
        
        wert = 100000;
        // b.setAnzahlDurchlaeufe(wert);
        
        double faktorGz = zeitmessungMtGz(b)/dauerGz;
        double dlNeuGz = wert / faktorGz;
        // System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)dlNeuGz);
         return dlNeuGz;
    }
    //diese Methode fuehrt die Lastberechnung für Fliesskommazahlen durch
    public double lastberechnungFkz(Benchmark b)
    {
        int dauerFkz = 3000;
        System.out.println("\n Lastberechnung fuer " + dauerFkz + "ms laeuft...");
        
        wert = 100000;
        b.setAnzahlDurchlaeufe(wert);
        
        double faktorFkz = zeitmessungFkz(b)/dauerFkz;
        double dlNeuFkz = wert / faktorFkz;
        
        return dlNeuFkz;
    }
    
    //diese Methode fuehrt die Lastberechnung für Fliesskommazahlen (Multithread) durch
    public double lastberechnungMtFkz(Benchmark b)
    {
        int dauerFkz = 3000;
        System.out.println("\n Lastberechnung fuer " + dauerFkz + "ms laeuft...");
        
        wert = 100000;
        // b.setAnzahlDurchlaeufe(wert);
        
        double faktorFkz = zeitmessungMtFkz(b)/dauerFkz;
        double dlNeuFkz = wert / faktorFkz;
        
        return dlNeuFkz;
    }
}
