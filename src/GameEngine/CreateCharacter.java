package GameEngine;

import java.util.Scanner;

public class CreateCharacter {

    static Scanner scanner = new Scanner(System.in);

    public CreateCharacter() {

    }

    public static String inputName() {

        String input = "";

        boolean inputName = true;
        while (inputName) {
            input = scanner.next();
            inputName = false;
        }

        return input;
    }
}
