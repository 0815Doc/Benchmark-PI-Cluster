
/**
 * Beschreiben Sie hier die Klasse TestUI.
 * 
 * @author (Michael Schneider) 
 * @version (1)
 */

import java.util.Scanner;

public class UI
{
    public static void main(String[] args)
    {
        int wert =  0;
        int fall = -1;
        boolean exit = false;

        Scanner einlesen = new Scanner(System.in);
       
        Fliesskommazahl f = new Fliesskommazahl();
        Ganzzahl g = new Ganzzahl();
        
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
                    
                    // vvvvv die Berechnung ist in case 1 & 2 redundant => separate methode!
                    long startGz = g.starteZeit();
                    g.berechneGz();
                    long stopGz = g.stoppeZeit();
                    // System.out.println(startGz);
                    // System.out.println(stopGz);
                    double zeitGz = stopGz - startGz;
                    // ^^^^^^
                    System.out.println(" Benoetigte Zeit zur Berechnung: "+ zeitGz/1000 + " Sekunden");
                    
                    System.out.println("\n\n -----------------------");
                    System.out.println("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                    break;

                case 2:
                    System.out.println("(FKZ) Anzahl der Durchlaeufe?");
                    wert = einlesen.nextInt();
                    f.setAnzahlDurchlaeufe(wert);
                    // vvvvv die Berechnung ist in case 1 & 2 redundant
                    long startFkz = f.starteZeit();
                    f.berechneFkz();
                    long stopFkz = f.stoppeZeit();
                    // System.out.println(startFkz);
                    // System.out.println(stopFkz);
                    double zeitFkz = stopFkz - startFkz;
                    // ^^^^^^
                    System.out.println("Benoetigte Zeit zur Berechnung: "+ zeitFkz/1000 + " Sekunden");
                    break;

                case 3: 
                    System.out.print('\u000C'); // Bildschirm leeren
                    System.out.println("3 Lastberechnung Ganzzahl"); 
                    System.out.println("-------------------------");
                    System.out.println("\n < 1 > Lastberechnung starten");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();

                    int dauerGz = 3000;
                    System.out.println("\n Lastberechnung fuer " + dauerGz + "ms laeuft...");
                    
                    // vvvvv die Berechnung ist in case 3 & 4 redundant => separate methode!
                    wert = 100000;
                    g.setAnzahlDurchlaeufe(wert);
                    long startGz1 = g.starteZeit();
                    g.berechneGz();
                    long stopGz1 = g.stoppeZeit();
                    // System.out.println(startGz1);
                    // System.out.println(stopGz1);
                    double zeitGz1 = stopGz1 - startGz1;
                    double faktorGz1 = zeitGz1/dauerGz;
                    double dlNeuGz1 = wert / faktorGz1;
                    
                    System.out.println("\n => Benoetigte Durchlaeufe: "+ (int)dlNeuGz1);
                    System.out.println("\n\n -----------------------");

                    System.out.print("< 0 > Hauptmenu");
                    if (einlesen.hasNextInt())
                        einlesen.nextInt();
                    break;
                
                case 4: 
                    System.out.println("(FKZ) Gewuenschte Laufzeit X in Sekunden angeben");
                    int dauerFkz1 = einlesen.nextInt() * 1000;

                    // vvvvv die Berechnung ist in case 3 & 4 redundant => separate methode!
                    wert = 100000;
                    f.setAnzahlDurchlaeufe(wert);
                    long startFkz1 = f.starteZeit();
                    f.berechneFkz();
                    long stopFkz1 = f.stoppeZeit();
                    // System.out.println(startFkz1);
                    // System.out.println(stopFkz1);
                    double zeitFkz1 = stopFkz1 - startFkz1;
                    double faktorFkz1 = zeitFkz1/dauerFkz1;
                    double dlNeuFkz1 = wert / faktorFkz1;
                    // ^^^^^^

                    System.out.println("Benoetigte Durchlaeufe: "+ (int)dlNeuFkz1);
                    break;

                // case 6: System.out.println("Wert eingeben.");
                        // wert = einlesen.nextInt();
                        // System.out.println("Der Wert ist " + l.anzahlVorkommen(wert) + " mal in der Liste enthalten.");                        
                // break;
                // case 7: if(l.istLeer())
                        // {
                            // System.out.println("Die Liste ist leer.");
                        // }
                        // else
                        // {
                            // System.out.println("Die Liste ist gefüllt.");
                        // }
                // break;
                // case 8:  System.out.println("Die Liste enthält " + l.laenge() + " Element(e).");        
                // break;
            }      
        }
    }
    
    // Programmpause in Millisekunden
    public static void pause(int dauer)
    {
        try { 
            Thread.sleep( dauer );
        } catch(Exception e) {}
    }

    // diese Methode erzeugt das Hauptmenu
    public static void hauptmenu()
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
        //System.out.println("5 = ");
        //System.out.println("6 = ");
        //System.out.println("7 = ");
        //System.out.println("8 = ");
        System.out.println("\n    < 0 > Programm beenden");
        System.out.println("========================================="); 
        
    }
}
