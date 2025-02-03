import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double bank = 15000;
        String[] rouletteMöglichkeiten = {
                "rot", "schwarz", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean spielen = true;

        while (spielen) {


            System.out.println("Wieviel Geld möchten Sie am Rouletttisch platzieren?");
            double einsatz = scanner.nextDouble();

            if (einsatz > bank) {
                System.out.println("Sie haben nicht genug Geld, um diesen Einsatz zu tätigen.");
                continue;
            }

            System.out.print("Wohin möchten Sie setzen? Rot, Schwarz oder welche Zahl von 0 - 36: ");
            String spielerWahl = scanner.next().toLowerCase();

            //ZufälligeAuswahl des Roulette-Ergebnisses
            int roulettIndex = random.nextInt(rouletteMöglichkeiten.length);
            String roulettErgebnis = rouletteMöglichkeiten[roulettIndex];

            System.out.println("Die Kugel ist auf " + roulettErgebnis + " gelandet.");

            //Vergleich derSpielerwahl mit dem Roulette-Ergebnis
            if (spielerWahl.equals(roulettErgebnis)) {
                System.out.println("Sie haben gewonnen!");
                bank += einsatz * 2;  // AuszahlungGewinn
            } else if ((spielerWahl.equals("rot") && isRot(roulettErgebnis)) ||
                    (spielerWahl.equals("schwarz") && isSchwarz(roulettErgebnis))) {
                System.out.println("Sie haben die Farbe richtig getippt!");
                bank += einsatz * 1.5;
                // Auszahlung bei richtiger Farbwette
            } else {
                System.out.println("Sie haben verloren.");
                bank -= einsatz;
            }

            System.out.println("Ihr aktuelles Guthaben beträgt: " + bank);



            //weiterspielen???
            System.out.println("Möchten Sie weiterspielen? (ja/nein)");
            String weiterSpielen = scanner.next().toLowerCase();

            //Schleife beenden
            if (weiterSpielen.equals("nein") || weiterSpielen.equals("n")) {
                spielen = false;
                System.out.println("Vielen Dank fürs Spielen! Ihr Endguthaben beträgt: " + bank);
            } else if (bank <= 0) {
                System.out.println("Sie haben kein Geld mehr. Das Spiel wird beendet.");
                spielen = false;  // Kein Geld --> Spiel wird beendet
            }
        }
    }

    //Überprüfung, ob die Zahl rot ist
    public static boolean isRot(String zahl) {
        String[] roteZahlen = {"1", "3", "5", "7", "9", "12", "14", "16", "18", "19", "21", "23", "25", "27", "30", "32", "34", "36"};
        for (String rot : roteZahlen) {
            if (rot.equals(zahl)) {
                return true;
            }
        }
        return false;
    }

    //Überprüfung, ob die Zahl schwarz ist
    public static boolean isSchwarz(String zahl) {
        String[] schwarzeZahlen = {"2", "4", "6", "8", "10", "11", "13", "15", "17", "20", "22", "24", "26", "28", "29", "31", "33", "35"};
        for (String schwarz : schwarzeZahlen) {
            if (schwarz.equals(zahl)) {
                return true;
            }
        }
        return false;
    }
}
