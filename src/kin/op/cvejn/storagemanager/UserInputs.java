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
        try {
            int number = sc.nextInt();
            sc.nextLine();
            return number;
        } catch (InputMismatchException e) {
            System.out.println("Zadejte prosim cislo.");
            sc.next();
            return getNumber();
        }
    }

    /**
     * Metoda pro získání textu od uživatele
     * @return Text od uživatele
     */
    public String getString() {
        try {
            String string = sc.nextLine();
            return string;
        } catch (InputMismatchException e) {
            System.out.println("Zadejte prosim retezec.");
            sc.next();
            return getString();
        }
    }
}
