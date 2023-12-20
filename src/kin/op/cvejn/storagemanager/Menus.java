package kin.op.cvejn.storagemanager;

/**
 *
 * @author Daniel Cvejn
 */
public class Menus {
  Printers printers = new Printers();
  UserInputs userInputs = new UserInputs();

  public void mainMenu () {
    int choice = -1;
    while (choice != 0) {
      printers.printMainMenu();
      System.out.println("Zadejte volbu: ");
      choice = userInputs.getNumber();
      switch (choice) {
        case 1:
          printers.printProducts();
          break;
        case 2:
          productEditMenu();
          break;
        case 3:
          printers.printStorage();
          break;
        case 0:
          System.exit(0);
          break;
        default:
          System.out.println("Zadejte prosim platnou volbu.");
          break;
      }
    }
  }

  public void productEditMenu () {
    int choice = -1;
    while (choice != 0) {
      printers.printProductsManagementMenu();
      System.out.println("Zadejte volbu: ");
      choice = userInputs.getNumber();
      switch (choice) {
        case 1:
          System.out.println("Zadejte nazev produktu: ");
          String name = userInputs.getString();
          System.out.println("Zadejte cenu produktu: ");
          int price = userInputs.getNumber();
          System.out.println("Zadejte pocet kusu produktu: ");
          int count = userInputs.getNumber();
          new Product(name, price, count);
          System.out.println("Produkt " + name + " s cenou " + price + "Kc a poctem kusu " + count + " byl vytvoren.");
          break;
        case 0:
          return;
        default:
          System.out.println("Zadejte prosim platnou volbu.");
          break;
      }
    }
  }
}
