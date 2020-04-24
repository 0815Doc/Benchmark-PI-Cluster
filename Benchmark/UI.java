                            
/**
 * Beschreiben Sie hier die Klasse TestUI.
 * 
 * @author (Michael Schneider) 
 * @version (1)
 */

import java.util.Scanner;
                        
public class UI
{
    Fliesskommazahl f = new Fliesskommazahl();
    Ganzzahl g = new Ganzzahl();
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

            while(fall < 0 || fall > 4)
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
                    g.setAnzahlDurchlaeufe(wert);
                        
                    System.out.println(" Benoetigte Zeit zur Berechnung: "+ zeitmessung(g)/1000 + " Sekunden");
                    
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
                    f.setAnzahlDurchlaeufe(wert);
                
                    System.out.println("Benoetigte Zeit zur Berechnung: "+ zeitmessung(f)/1000 + " Sekunden");
                 
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
         
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)lastberechnung(g));
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
             
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)lastberechnung(f));
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
        System.out.println("\n    < 0 > Programm beenden");
        System.out.println("========================================="); 
        
    }
    
    //diese Methode fuerhrt die Zeitmessung für Ganzzahlen durch
    public double zeitmessung(Ganzzahl g)
    {
        this.g = g;//Wird das benötigt??
        long startGz = g.starteZeit();
        g.berechneGz();
        long stopGz = g.stoppeZeit();
        double zeitGz = stopGz - startGz;
        return zeitGz;            
    }
    
    //diese Methode fuerhrt die Zeitmessung für Fliesskommazahlen durch
    public double zeitmessung(Fliesskommazahl f)
    {
        this.f = f;//Wird das benötigt??
        long startFkz = f.starteZeit();
        f.berechneFkz();
        long stopFkz = f.stoppeZeit();
        double zeitFkz = stopFkz - startFkz;
        return zeitFkz;
    }
    
    //diese Methode fuerhrt die Lastberechnung für Ganzzahlen durch
    public double lastberechnung(Ganzzahl g)
    {
        this.g = g;//Wird das benötigt??
        int dauerGz = 3000;
        System.out.println("\n Lastberechnung fuer " + dauerGz + "ms laeuft...");
        
        wert = 100000;
        g.setAnzahlDurchlaeufe(wert);
        
        double faktorGz = zeitmessung(g)/dauerGz;
        double dlNeuGz = wert / faktorGz;
        
        return dlNeuGz;
    }
    
    //diese Methode fuerhrt die Lastberechnung für Fliesskommazahlen durch
    public double lastberechnung(Fliesskommazahl f)
    {
        this.f = f; //Wird das benötigt??
        int dauerFkz = 3000;
        System.out.println("\n Lastberechnung fuer " + dauerFkz + "ms laeuft...");
        
        wert = 100000;
        f.setAnzahlDurchlaeufe(wert);
        
        double faktorFkz = zeitmessung(f)/dauerFkz;
        double dlNeuFkz = wert / faktorFkz;
        
        return dlNeuFkz;
    }
}
