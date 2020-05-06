                            
/**
 * Beschreiben Sie hier die Klasse TestUI.
 * 
 * @author (Michael Schneider) 
 * @version (1)
 */

import java.util.Scanner;
                        
public class UI
{
    Benchmark   b    = new Benchmark();
    int         wert = 0;
    
    // statisches Hauptprogramm
    public static void main(String[] args)
    {
        UI emil = new UI();
        emil.start();
    }
    

    public void start()
    {
        int     fall = -1;
        boolean exit =  false;
        double  tmp  = -1;

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
                    tmp = b.zeitmessungGz()/1000.; 
                        
                    System.out.println(" Benoetigte Zeit zur Berechnung: "+ tmp + " Sekunden");
                    
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
                    tmp = b.zeitmessungFkz()/1000.; 
                
                    System.out.println("Benoetigte Zeit zur Berechnung: "+ tmp + " Sekunden");
                 
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

                    tmp = b.lastberechnungGz();

                    System.out.println("\n => Benoetigte Durchlaeufe: "+ tmp);
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
             
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ b.lastberechnungFkz());
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
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ b.lastberechnungGz_m());
                    
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
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ b.lastberechnungFkz_m());
                    
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
}
