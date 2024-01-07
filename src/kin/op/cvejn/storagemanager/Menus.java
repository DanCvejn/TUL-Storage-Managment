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
        case 4:
          storageEditMenu();
          break;
        case 5:
          new Testing().createTestData();
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
          System.out.println("Vytvorit produkt:");
          System.out.println("Zadejte nazev produktu: ");
          String name = userInputs.getString();
          System.out.println("Zadejte cenu produktu: ");
          int price = userInputs.getNumber();
          System.out.println("Zadejte pocet kusu produktu: ");
          int count = userInputs.getNumber();
          new Product(name, price, count);
          System.out.println("Produkt " + name + " s cenou " + price + "Kc a poctem kusu " + count + " byl vytvoren.");
          printers.printOptionEnd();
          break;
        case 2:
          System.out.println("\nUlozit produkt:");
          printers.printProductsList();
          if (Product.productsList == null) {
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte nazev produktu: ");
          name = userInputs.getString();
          Product product = Product.getProductByName(name);
          if (product == null) {
            System.out.println("Produkt s nazvem " + name + " nebyl nalezen.");
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte skladovaci prostor (rada: Y, sloupec: X):");
          printers.printStorageList();
          if (Storage.storagesList == null) {
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte souradnici X: ");
          int x = userInputs.getNumber();
          System.out.println("Zadejte souradnici Y: ");
          int y = userInputs.getNumber();
          Storage storage = Storage.getStorageByCoordinates(x, y);
          if (storage == null) {
            System.out.println("Prostor na souradnicich " + x + ", " + y + " nebyl nalezen.");
            printers.printOptionEnd();
            break;
          }
          storage.storeProduct(product);
          printers.printOptionEnd();
          break;
        case 3:
          System.out.println("\nUpravit produkt:");
          printers.printProductsList();
          if (Product.productsList == null) {
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte nazev produktu: ");
          name = userInputs.getString();
          product = Product.getProductByName(name);
          if (product == null) {
            System.out.println("Produkt s nazvem " + name + " nebyl nalezen.");
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte novou cenu produktu: ");
          price = userInputs.getNumber();
          System.out.println("Zadejte novy pocet kusu produktu: ");
          count = userInputs.getNumber();
          product.setPrice(price);
          product.setCount(count);
          System.out.println("Produkt " + name + " byl upraven.");
          printers.printOptionEnd();
          break;
        case 4:
          System.out.println("\nOdstranit produkt:");
          printers.printProductsList();
          if (Product.productsList == null) {
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte nazev produktu: ");
          name = userInputs.getString();
          product = Product.getProductByName(name);
          if (product == null) {
            System.out.println("Produkt s nazvem " + name + " nebyl nalezen.");
            printers.printOptionEnd();
            break;
          }
          Product.removeProductByName(name);
          System.out.println("Produkt " + name + " byl odstranen.");
          printers.printOptionEnd();
          break;
        case 0:
          return;
        default:
          System.out.println("Zadejte prosim platnou volbu.");
          break;
      }
    }
  }

  public void storageEditMenu() {
    int choice = -1;
    while (choice != 0) {
      printers.printStorageManagementMenu();
      System.out.println("Zadejte volbu: ");
      choice = userInputs.getNumber();
      switch (choice) {
        case 1:
          System.out.println("Vytvorit prostor:");
          System.out.println("Zadejte souradnici X: ");
          int x = userInputs.getNumber();
          System.out.println("Zadejte souradnici Y: ");
          int y = userInputs.getNumber();
          System.out.println("Zadejte velikost prostoru: ");
          int size = userInputs.getNumber();
          new Storage(size, x, y);
          System.out.println("Prostor " + x + ". sloupec, " + y + ". rada s velikosti " + size + " byl vytvoren.");
          printers.printOptionEnd();
          break;
        case 2:
          System.out.println("\nUpravit prostor:");
          System.out.println("rada: Y, sloupec: X");
          printers.printStorageList();
          if (Storage.storagesList == null) {
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte souradnici X: ");
          x = userInputs.getNumber();
          System.out.println("Zadejte souradnici Y: ");
          y = userInputs.getNumber();
          Storage storage = Storage.getStorageByCoordinates(x, y);
          if (storage == null) {
            System.out.println("Prostor na souradnicich " + x + ", " + y + " nebyl nalezen.");
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte novou velikost prostoru: ");
          size = userInputs.getNumber();
          storage.setSize(size);
          System.out.println("Prostor " + x + ". sloupec, " + y + ". rada byl upraven.");
          printers.printOptionEnd();
          break;
        case 3:
          System.out.println("\nOdstranit prostor:");
          System.out.println("rada: Y, sloupec: X");
          printers.printStorageList();
          if (Storage.storagesList == null) {
            printers.printOptionEnd();
            break;
          }
          System.out.println("Zadejte souradnici X: ");
          x = userInputs.getNumber();
          System.out.println("Zadejte souradnici Y: ");
          y = userInputs.getNumber();
          storage = Storage.getStorageByCoordinates(x, y);
          if (storage == null) {
            System.out.println("Prostor na souradnicich " + x + ", " + y + " nebyl nalezen.");
            printers.printOptionEnd();
            break;
          }
          Storage.removeStorageByCoordinates(x, y);
          System.out.println("Prostor " + x + ". sloupec, " + y + ". rada byl odstranen.");
          printers.printOptionEnd();
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
