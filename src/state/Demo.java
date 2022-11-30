package state;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();

        System.out.println("Welcome to Tamagotchi Island!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What do you want to do? (f)eed, (d)ance or (s)tatus.");
            String response = switch (scanner.nextLine()) {
                case "f" -> tamagotchi.feed();
                case "d" -> tamagotchi.dance();
                case  "s" -> tamagotchi.status();
                default -> "Type in f, d or s!";
            };
            System.out.println(response);
            System.out.println();
        }
    }
}
