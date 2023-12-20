package kin.op.cvejn.storagemanager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Cvejn
 */
public class UserInputs {
  Scanner sc = new Scanner(System.in);

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
