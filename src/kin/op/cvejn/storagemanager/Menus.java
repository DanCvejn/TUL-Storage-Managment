package kin.op.cvejn.storagemanager;

/**
 * Třída obsahuje metody pro výpis menu a volání metod pro správu produktů a skladů.
 * @author Daniel Cvejn
 */
public class Menus {

    Printers printers = new Printers();
    UserInputs userInputs = new UserInputs();
    Product[] productsList = Product.getProductList();
    Storage[] storagesList = Storage.getStoragesList();

    /**
     * Vypíše hlavní menu a volá metody pro správu produktů a skladů.
     */
    public void mainMenu() {
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

    /**
     * Vypíše menu pro správu produktů a volá metody pro vytváření, ukládání, úpravu a odstraňování produktů.
     */
    public void productEditMenu() {
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
                    if (Product.getProductList() == null) {
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
                    printers.printStorageList();
                    if (Storage.getStoragesList() == null) {
                        printers.printOptionEnd();
                        break;
                    }
                    System.out.println("Zadejte id prostoru: ");
                    int id = userInputs.getNumber();
                    Storage storage = Storage.getStorageById(id);
                    if (storage == null) {
                        System.out.println("Prostor s timto id nebyl nalezen.");
                        printers.printOptionEnd();
                        break;
                    }
                    if (storage.storedProducts.length == storage.getSize()) {
                        System.out.println("Prostor s timto id je plny.");
                        printers.printOptionEnd();
                        break;
                    }
                    storage.storeProduct(product);
                    printers.printOptionEnd();
                    break;
                case 3:
                    System.out.println("\nUpravit produkt:");
                    printers.printProductsList();
                    if (Product.getProductList() == null) {
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
                    System.out.println("Vybrany produkt: " + product.getName() + ", cena: " + product.getPrice() + "Kc, pocet kusu: " + product.getCount());
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
                    if (Product.getProductList() == null) {
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

    /**
     * Vypíše menu pro správu skladů a volá metody pro vytváření, vyskladňování, úpravu a odstraňování skladů.
     */
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
                    System.out.println("\nSpravovat ulozene produkty v prostoru");
                    printers.printStorageList();
                    if (Storage.getStoragesList() == null) {
                        printers.printOptionEnd();
                        break;
                    }
                    System.out.println("Zadejte id prostoru: ");
                    int id = userInputs.getNumber();
                    Storage storage = Storage.getStorageById(id);
                    if (storage == null) {
                        System.out.println("Prostor s timto id nebyl nalezen.");
                        printers.printOptionEnd();
                        break;
                    }
                    printers.printStoredProductsList(storage);
                    System.out.println("Zadejte nazev produktu, ktery ma byt odstranen z prostoru: ");
                    String name = userInputs.getString();
                    Product product = Product.getProductByName(name);
                    if (product == null) {
                        System.out.println("Produkt s nazvem " + name + " nebyl nalezen.");
                        printers.printOptionEnd();
                        break;
                    }
                    storage.unstoreProduct(product);
                    System.out.println("Produkt " + name + " byl odstranen z prostoru s id " + id);
                    printers.printOptionEnd();
                    break;
                case 3:
                    System.out.println("\nUpravit prostor:");
                    printers.printStorageList();
                    if (Storage.getStoragesList() == null) {
                        printers.printOptionEnd();
                        break;
                    }
                    System.out.println("Zadejte id prostoru: ");
                    id = userInputs.getNumber();
                    storage = Storage.getStorageById(id);
                    if (storage == null) {
                        System.out.println("Prostor s timto id nebyl nalezen.");
                        printers.printOptionEnd();
                        break;
                    }
                    System.out.println("Vybrany prostor: " + storage.getCoordinateX() + ". sloupec, " + storage.getCoordinateY() + ". rada, velikost: " + storage.getSize());
                    System.out.println("Zadejte novou velikost prostoru: ");
                    size = userInputs.getNumber();
                    storage.setSize(size);
                    System.out.println("Prostor s id " + id + " byl upraven.");
                    printers.printOptionEnd();
                    break;
                case 4:
                    System.out.println("\nOdstranit prostor:");
                    printers.printStorageList();
                    if (Storage.getStoragesList() == null) {
                        printers.printOptionEnd();
                        break;
                    }
                    System.out.println("Zadejte id prostoru: ");
                    id = userInputs.getNumber();
                    storage = Storage.getStorageById(id);
                    if (storage == null) {
                        System.out.println("Prostor s timto id nebyl nalezen.");
                        printers.printOptionEnd();
                        break;
                    }
                    Storage.removeStorageById(id);
                    System.out.println("Prostor s id " + id + " byl odstranen.");
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
