package games.firstto21;
import java.util.Scanner;

public class FirstTo21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentNumber = 0;
        String red = "\u001B[31m";
        System.out.println("Välkommen till spelet! Den som säger 21 vinner.");
        System.out.println("Du börjar!");

        while (true) {
            int playerMove = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Säg 1 eller 2: ");
                if (scanner.hasNextInt()) {
                    playerMove = scanner.nextInt();
                    if (playerMove == 1 || playerMove == 2) {
                        validInput = true;
                    } else {
                        System.out.println("Ogiltigt val, försök igen.");
                    }
                } else {
                    System.out.println("Ogiltigt val, försök igen.");
                    scanner.next();
                }
            }

            currentNumber += playerMove;
            System.out.println("Du sa: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println("Grattis! Du vinner!");
                break;
            }

            int computerMove = ((currentNumber+1) % 3) == 0 ? 1 : 2;
            currentNumber += computerMove;
            System.out.println("Datorn säger: " + currentNumber);

            if (currentNumber >= 21) {
                System.out.println(red+"Datorn vinner! Bättre lycka nästa gång.");
                break;
            }
        }
        scanner.close();
    }
}