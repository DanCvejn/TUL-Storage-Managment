package kin.op.cvejn.storagemanager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Tato třída slouží k získávání vstupů od uživatele z konzole.
 * @author Daniel Cvejn
 */
public class UserInputs {

    Scanner sc = new Scanner(System.in);

    /**
     * Metoda pro získání čísla od uživatele
     * @return Číslo od uživatele
     */
    public int getNumber() {
        boolean isNumber = false;
        int number = 0;
        while (!isNumber) {
            try {
                number = sc.nextInt();
                sc.nextLine();
                isNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Zadejte prosim cislo.");
                sc.nextLine();
                isNumber = false;
            }
        }
        return number;
    }

    /**
     * Metoda pro získání textu od uživatele
     * @return Text od uživatele
     */
    public String getString() {
        boolean isString = false;
        String string = "";
        while (!isString) {
            try {
                string = sc.nextLine();
                isString = true;
            } catch (InputMismatchException e) {
                System.out.println("Zadejte prosim retezec.");
                sc.nextLine();
                isString = false;
            }
        }
        return string;
    }
}
