
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
        int wert;
        int fall;
        char auswahl;
        String s = "";
        Scanner einlesen = new Scanner(System.in);
        // Benchmark b = new Benchmark();
        Fliesskommazahl f = new Fliesskommazahl();
        Ganzzahl g = new Ganzzahl();
        
        do
        {
            System.out.println("Was möchten Sie tun?"); 
            System.out.println("1 = (GZ)Zeit für X Durchläufe berechnen");
            System.out.println("2 = (GZ)Durchläufe für ca. X Sekunden berechnen");
            System.out.println("3 = (FKZ)Zeit für X Durchläufe berechnen");
            System.out.println("4 = (FKZ)Durchläufe für ca. X Sekunden berechnen");
            System.out.println("5 = ");
            System.out.println("6 = ");
            System.out.println("7 = ");
            System.out.println("8 = ");
            System.out.println("9 = ");
            fall = einlesen.nextInt(); 
            
            switch(fall)
            {
                case 1: System.out.println("(Gz) Anzahl der Durchläufe?");
                        wert = einlesen.nextInt();
                        g.setAnzahlDurchlaeufe(wert);
                        long startGz = g.starteZeit();
                        g.berechneGz();
                        long stopGz = g.stoppeZeit();
                        // System.out.println(startGz);
                        // System.out.println(stopGz);
                        double zeitGz = stopGz - startGz;
                        System.out.println("Benötigte Zeit zur Berechnung: "+ zeitGz/1000 + " Sekunden");
                break;
                case 2: System.out.println("(GZ) Gewünschte Zeit X in Sekunden angeben");
                        int dauerGz = einlesen.nextInt() * 1000;
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
                        System.out.println("Benötigte Durchläufe: "+ (int)dlNeuGz1);
                break;
                case 3: System.out.println("(FKZ) Anzahl der Durchläufe?");
                        wert = einlesen.nextInt();
                        f.setAnzahlDurchlaeufe(wert);
                        long startFkz = f.starteZeit();
                        f.berechneFkz();
                        long stopFkz = f.stoppeZeit();
                        // System.out.println(startFkz);
                        // System.out.println(stopFkz);
                        double zeitFkz = stopFkz - startFkz;
                        System.out.println("Benötigte Zeit zur Berechnung: "+ zeitFkz/1000 + " Sekunden");
                break;
                case 4: System.out.println("(FKZ) Gewünschte Zeit X in Sekunden angeben");
                        int dauerFkz1 = einlesen.nextInt() * 1000;
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
                        System.out.println("Benötigte Durchläufe: "+ (int)dlNeuFkz1);
                break;
                // case 5: System.out.println("Wert eingeben.");
                        // wert = einlesen.nextInt();
                        // l.loescheEinmal(wert);
                        // System.out.println(" 1. Wert des Elementes wurde gelöscht, falls vorhanden.");
                // break;
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
                // case 9: System.out.println("In der Liste sind folgende Elemente gespeichert:");
                        // System.out.println(l.toString());
                // break;
                default: System.out.println("Falche Eingabe!");
            }      
                System.out.print("Weiter mit J: ");
                auswahl = einlesen.next().charAt(0);
        }
        while(auswahl == 'J' || auswahl == 'j');
    }  
}