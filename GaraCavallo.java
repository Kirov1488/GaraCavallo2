import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GaraCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire la lunghezza del percorso in metri: ");
        int pathLength = scanner.nextInt();
        scanner.nextLine();

        List<Cavallo> cavalli = new ArrayList<>();
        System.out.print("Inserire il numero di cavalli in gara: ");
        int participantsNum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < participantsNum; i++) {
            System.out.print("Inserire il nome del cavallo " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.println("Inserire la velocità del cavallo " + (i + 1) + ": ");
            int speed = scanner.nextInt();
            cavalli.add(new Cavallo(name, speed, pathLength));
        }

        System.out.println("\nLa gara inizia!\n");

        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nGara terminata!");
        scanner.close();
    }
}
