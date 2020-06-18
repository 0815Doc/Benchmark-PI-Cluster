                            
/**
 * Beschreiben Sie hier die Klasse TestUI.
 * 
 * @author (Michael Schneider) 
 * @version (1)
 */
import java.text.*;
import java.util.Scanner;
                        
public class UI
{
    // Benchmark   b    = new Benchmark();
    private Ganzzahl_m          gm ;
    private Ganzzahl          g ;
    private Fliesskommazahl_m   fm ;
    private Fliesskommazahl   f ;
    private int wert                       = 0;
    protected DecimalFormat gerundet = new DecimalFormat("#0");
    private boolean[] threadStatus;
    private int anzahlThreads              = 1;
    private int anzahlDurchlaeufe          = 10000;
    private static int wunschDauer         = 10000;
    private static int uebergabeThread     = 0;
    private double gestoppteZeit;
    
    public UI()
    {
        gm = new Ganzzahl_m(this, 0);
        g = new Ganzzahl(this);
        fm = new Fliesskommazahl_m(this, 0);
        f = new Fliesskommazahl(this);
        
    }
    
    public void setGestoppteZeit(double wert)
    {
       gestoppteZeit = wert; 
    }
    
    public void setAnzahlDurchlaeufe(int anzahl)
    {
       anzahlDurchlaeufe = anzahl; 
    }
    
    public int getAnzahlDurchlaeufe()
    {
       return anzahlDurchlaeufe; 
    }
    
    public void setAnzahlThreads(int anzahl)
    {
       anzahlThreads = anzahl;
       threadStatus = new boolean[anzahl];
    }
    
    public int getAnzahlThreads()
    {
       return anzahlThreads; 
    }
    
    public void setThreadStatus(int index, boolean status)
    {
       threadStatus[index] = status; 
    }
    
    public boolean getThreadStatus(int index)
    {
       return threadStatus[index];
    }
         
    // statisches Hauptprogramm
    public static void main(String[] args)
    {
        UI emil = new UI();
        
        if (args.length >0)
        {
            // Bildschirm leeren
            System.out.print('\u000C');
            for (int i = 0 ; i< args.length;i++)
            {
                
                switch (args[i])
                {
                    case "-a": 
                     //                        
                       uebergabeThread = Integer.parseInt(args[i+1]);
                       System.out.println("Anzahl Threads = " + uebergabeThread);
                       i++;
                       
                    break;
                    
                    case "-t": 
                     // Abfrage der Zeit
                       wunschDauer = Integer.parseInt(args[i+1]);
                       i++;
                       System.out.println("Zeit = "+ wunschDauer+ "ms.");
                       
                    break;
                }
            }
            emil.automode();
        }
        else
        {
            emil.start();
        }   
    }
    
    public void automode()
    {
        if (uebergabeThread == 0)
        {
            setAnzahlThreads(4);
        }
        else
        {
            setAnzahlThreads(uebergabeThread);
        }
        
        // double  dauer       = 10000;
        anzahlDurchlaeufe   = 10000;
        
        // Durchläufe für 10 Sekunden Laufzeit integer Singlethread
        g.rechne();
        double faktor =  (double)wunschDauer / g.zeitmessung() ; 
        double temp   =   (anzahlDurchlaeufe * faktor);
        anzahlDurchlaeufe =  (int)temp;
        System.out.println("Integer");
        System.out.println("Für eine Laufzeit von " + wunschDauer/1000 +" Sekunden werden "+ anzahlDurchlaeufe + " Durchlaeufe benötigt.");      
        System.out.println();
            //Rechne 10 Sekunden Singlethread --> IOPS
        System.out.println("Starte Singlethread Test mit "+ anzahlDurchlaeufe + " Durchlaeufen....");        
        g.rechne();
        double zeit = g.getGestoppteZeit()/1000.;                    
        System.out.println("     Benoetigte Zeit zur Berechnung: "+ zeit + " Sekunden.");
        System.out.println("     Singelthread Rechenleistung: "+ gerundet.format(anzahlDurchlaeufe/zeit) + " IOPS.");        
        
            //Rechne 10 Sekunden Multithread (4)--> IOPS                    
        System.out.println("Starte Multithread Test mit "+ anzahlDurchlaeufe + " Durchlaeufen und " + getAnzahlThreads() +" Threads....");
        gm.rechne();
        
        pause(10000);
        System.out.println();
        
        setAnzahlThreads(0);
        if (uebergabeThread == 0)
        {
            setAnzahlThreads(4);
        }
        else
        {
            setAnzahlThreads(uebergabeThread);
        }
        
        // Durchläufe für 10 Sekunden Laufzeit double Singelthread
        anzahlDurchlaeufe = 10000;
        f.rechne();
        faktor =  (double)wunschDauer / f.getGestoppteZeit() ;
        temp   =  (anzahlDurchlaeufe * faktor);
        anzahlDurchlaeufe =  (int)temp;
        System.out.println("Double");
        System.out.println("Für eine Laufzeit von " + wunschDauer/1000 + " Sekunden werden "+ anzahlDurchlaeufe + " Durchlaeufe benötigt.");
        System.out.println();
            //Rechne 10 Sekunden Singlethread --> FOPS
        System.out.println("Starte Singlethread Test mit "+ anzahlDurchlaeufe + " Durchlaeufen....");        
        f.rechne();
        zeit = f.getGestoppteZeit()/1000.;
        System.out.println("     Benoetigte Zeit zur Berechnung: "+ zeit + " Sekunden.");
        System.out.println("     Singelthread Rechenleistung: "+ gerundet.format(anzahlDurchlaeufe/zeit) + " FOPS.");        
            //Rechne 10 Sekunden Multithread (4)--> FOPS
                           
        System.out.println("Starte Multithread Test mit "+ anzahlDurchlaeufe + " Durchlaeufen und " + getAnzahlThreads() +" Threads....");
        fm.rechne();
        
        pause(10000);
        System.out.println();
    }

    public void start()
    {
        int     fall = -1;
        boolean exit =  false;
        double  tmp  ;

        Scanner einlesen = new Scanner(System.in);
            
        while(!exit)
        {
            hauptmenu();

            fall = -1;
            System.out.print("\n Eingabe: ");

            while(fall < 0 || fall > 8)
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
                    setAnzahlDurchlaeufe(wert);                    
                    g.rechne();
                    tmp = g.getGestoppteZeit()/1000.;                    
                    System.out.println(" Benoetigte Zeit zur Berechnung: "+ tmp + " Sekunden");
                    System.out.println(" Rechenleistung: "+ gerundet.format(wert/tmp) + " IOPS");                    
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
                    setAnzahlDurchlaeufe(wert);
                    f.rechne();
                    tmp = f.getGestoppteZeit()/1000.;                
                    System.out.println(" Benoetigte Zeit zur Berechnung: "+ tmp + " Sekunden");
                    System.out.println(" Rechenleistung: "+ gerundet.format(wert/tmp) + " FOPS");                   
                    System.out.println("\n\n -----------------------");
                    System.out.println("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
                
                case 3: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("3 Zeitmessung Ganzzahl Multithread"); 
                    System.out.println("-----------------------");
                    // ohne print (ohne "ln"), damit der eingegebene Wert hinter dem Text erscheint
                    System.out.print("\n Anzahl der Durchlaeufe? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                    setAnzahlDurchlaeufe(wert);                     
                     // ohne print (ohne "ln"), damit der eingegebene Wert hinter dem Text erscheint
                    System.out.print("\n Anzahl der Threads? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                    setAnzahlThreads(wert);                    
                    System.out.println("\n Test laeuft...");                    
                    gm.rechne();                   
                    System.out.println("\n\n -----------------------");
                    System.out.println("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                    einlesen.nextInt();
                break;
                
                case 4: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("4 Zeitmessung Fliesskomma Multithread"); 
                    System.out.println("-----------------------");
                    // ohne print (ohne "ln"), damit der eingegebene Wert hinter dem Text erscheint
                    System.out.print("\n Anzahl der Durchlaeufe? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                    setAnzahlDurchlaeufe(wert);                     
                     // ohne print (ohne "ln"), damit der eingegebene Wert hinter dem Text erscheint
                    System.out.print("\n Anzahl der Threads? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                    setAnzahlThreads(wert);                     
                    System.out.println("\n Test laeuft...");                    
                    fm.rechne();                   
                    System.out.println("\n\n -----------------------");
                    System.out.println("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                    einlesen.nextInt();
                break;
                
                case 5: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("5 Lastberechnung Ganzzahl"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten");// jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();                       
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ lastberechnungG());                    
                    System.out.println("\n\n -----------------------");        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
            
                case 6: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("6 Lastberechnung Fliesskommazahl"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten"); // jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();             
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ lastberechnungF());
                    System.out.println("\n\n -----------------------");        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
                
                case 7: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("7 Lastberechnung MultiGanzzahl"); 
                    System.out.println("-------------------------");
                    
                    
                    System.out.println("\n < 1 > Lastberechnung starten");// jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    // if (einlesen.hasNextInt())
                        // einlesen.nextInt();
                        
                    System.out.print("\n Anzahl der Threads? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                    setAnzahlThreads(wert);
                    System.out.println("\n =>  Benoetigte Durchlaeufe: "+ lastberechnungGm());                    
                    pause(5000);
                    System.out.println("\n\n -----------------------");        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break;
                
                case 8:                    
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("8 Lastberechnung MultiFliesskomma"); 
                    System.out.println("-------------------------");
                    System.out.print("\n Anzahl der Threads? => ");
                    if (einlesen.hasNextInt())
                        wert = einlesen.nextInt();
                    setAnzahlThreads(wert);
                    System.out.println("\n < 1 > Lastberechnung starten");// jede Eingabe startet die Berechnung...Eingabe von Buchstaben führt zum Abbruch
                    // if (einlesen.hasNextInt())
                        // einlesen.nextInt();
                    System.out.println("\n =>  Benoetigte Durchlaeufe: "+ lastberechnungFm());                    
                    pause(5000);
                    System.out.println("\n\n -----------------------");        
                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                break; 
            }      
        }
    }


    // Programmpause in Millisekunden
    public void pause(int dauer)
    {
        try { 
            Thread.sleep( dauer );
        } catch(Exception e) {}
    }


    // Hauptmenu anzeigen
    public void hauptmenu()
    {
        System.out.print('\u000C'); // Bildschirm leeren
        
        System.out.println("========================================="); 
        System.out.println("Hauptmenu"); 
        System.out.println("---------"); 
        System.out.println("\n  Zeitmessung (Laufzeit fuer X Durchlaeufe ermitteln)"); 
        System.out.println("    < 1 > Zeitmessung Ganzzahl");
        System.out.println("    < 2 > Zeitmessung Fliesskomma");
        System.out.println("    < 3 > Zeitmessung MultiGanzahl");
        System.out.println("    < 4 > Zeitmessung MultiFliesskomma");
        
        System.out.println("\n  Lastberechnung (benoetigte Durchlaeufe fuer 3 Sekunden Laufzeit ermitteln)"); 
        System.out.println("    < 5 > Ganzahl");
        System.out.println("    < 6 > Fliesskomma");
        System.out.println("    < 7 > MultiGanzahl");
        System.out.println("    < 8 > MultiFliesskomma");
       
        
        System.out.println("\n    < 0 > Programm beenden");
        System.out.println("========================================="); 
        
    }
    
    public long lastberechnungG()
    {
        double  dauer       = 3000;
        anzahlDurchlaeufe   = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
                
        g.rechne();
        
        double faktor = g.getGestoppteZeit() / dauer;

        return (int)(anzahlDurchlaeufe / faktor);
    } 
        
    public long lastberechnungF()
    {
        double  dauer       = 3000;
        anzahlDurchlaeufe   = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
                
        f.rechne();
        
        double faktor = f.getGestoppteZeit() / dauer;

        return (int)(anzahlDurchlaeufe / faktor);
    } 
    
    public long lastberechnungGm()
    {
        double  dauer       = 3000;
        anzahlDurchlaeufe   = 100000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
                
        gm.rechne();
        pause(5000);
        double faktor =  gestoppteZeit /(dauer/1000) ;

        return (int)(anzahlDurchlaeufe / faktor);
    } 
    
    public long lastberechnungFm()
    {
        double  dauer       = 3000;
        anzahlDurchlaeufe   = 10000;

        System.out.println("\n Lastberechnung fuer " + dauer + "ms laeuft...");
                
        fm.rechne();
        pause(5000);
        double faktor = gestoppteZeit / (dauer/1000);

        return (int)(anzahlDurchlaeufe / faktor);
    } 
}
