package kin.op.cvejn.storagemanager;

/**
 * Tato třída slouží k výpisu textů a menu do konzole.
 * @author Daniel Cvejn
 */
public class Printers {

    /**
     * Ukončí předchozí akci a po stisknutí ENTER pokračuje.
     */
    public void printOptionEnd () {
        System.out.println("\nPro pokracovani stisknete ENTER.");
        new UserInputs().getString();
    }

    /**
     * Vypíše hlavičku programu.
     */
    public void printHead () {
        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|   Vitejte ve sprave skladu XXX   |");
        System.out.println("|                                  |");
        System.out.println("====================================");
    }

    /**
     * Vypíše přehled produktů.
     */
    public void printProducts () {
        System.out.println("\n\n====================================");
        System.out.println("\nPrehled vsech produktu");
        if (Product.getProductList() == null || Product.getProductList().length == 0) {
            System.out.println("Zadne produkty nejsou vytvoreny.");
            System.out.println("\n====================================");
            return;
        }
        for (Product product : Product.getProductList()) {
            System.out.println(" - Produkt: " + product.getName());
            System.out.println("   - Cena: " + product.getPrice() + "Kc");
            System.out.println("   - Pocet kusu na sklade: " + product.getCount() + "ks");
        }
        printOptionEnd();
        System.out.println("\n====================================");
    }

    /**
     * Vypíše přehled skladů.
     */
    public void printStorage () {
        System.out.println("\n\n====================================");
        System.out.println("\nPrehled skladu");
        if (Storage.getStoragesList() == null || Storage.getStoragesList().length == 0) {
            System.out.println("Zadne skladovaci prostory nejsou vytvoreny.");
            System.out.println("\n====================================");
            return;
        }
        int storedProductsLength;
        for (Storage storage : Storage.getStoragesList()) {
            if (storage.storedProducts == null) storedProductsLength = 0;
            else storedProductsLength = storage.storedProducts.length;
            System.out.println("ID: " + storage.getId() + " - " + storage.getCoordinateY() + ". rada, " + storage.getCoordinateX() + ". sloupec");
            System.out.println(" - Vyuzito " + storedProductsLength + "/" + storage.getSize());
            System.out.println(" - Produkty:");
            if (storage.storedProducts == null || storage.storedProducts.length == 0) {
                System.out.println("   - Zadne produkty nejsou ulozeny.");
                continue;
            }
            for (Product storedProduct : storage.storedProducts) {
                System.out.println("   - " + storedProduct.getName());
            }
        }
        System.out.println("\nNeulozene produkty");
        if (Product.getProductList() == null || Product.getProductList().length == 0) {
            System.out.println("Zadne produkty nejsou vytvoreny.");
            System.out.println("\n====================================");
            return;
        }
        for (Product product : Product.getProductList()) {
            if (!product.getStored()) {
                System.out.println(product.getName());
            }
        }
        printOptionEnd();
        System.out.println("\n====================================");
    }

    /**
     * Vypíše seznam produktů.
     */
    public void printProductsList () {
        System.out.println("\nSeznam produktu");
        Product[] productList = Product.getProductList();
        if (productList == null || productList.length == 0) {
            System.out.println("Zadne produkty nejsou vytvoreny.");
            return;
        }
        for (int i = 0; i < productList.length; i++) {
            System.out.println(i + 1 + ". " + productList[i].getName() + " - " + (productList[i].getStored() ? "ulozen" : "neulozen"));
        }
    }

    /**
     * Vypíše seznam skladů.
     */
    public void printStorageList () {
        System.out.println("\nSeznam skladovych protor");
        Storage[] storagesList = Storage.getStoragesList();
        if (storagesList == null || storagesList.length == 0) {
            System.out.println("Zadne prostory nejsou vytvoreny.");
            return;
        }
        for (int i = 0; i < storagesList.length; i++) {
            System.out.println(storagesList[i].getId() + ". " + storagesList[i].getCoordinateY() + ". rada, " + storagesList[i].getCoordinateX() + ". sloupec - " + (storagesList[i].storedProducts == null ? 0 : storagesList[i].storedProducts.length) + "/" + storagesList[i].getSize());
        }
    }

    /**
     * Vypíše seznam produktů uložených v daném skladu.
     */
    public void printStoredProductsList (Storage storage) {
        System.out.println("\nSeznam ulozenych produktu");
        if (storage.storedProducts == null) {
            System.out.println("Zadne produkty zde nejsou ulozeny.");
            return;
        }
        for (int i = 0; i < storage.storedProducts.length; i++) {
            System.out.println(i + 1 + ". " + storage.storedProducts[i].getName());
        }
    }

    /**
     * Vypíše hlavní menu.
     */
    public void printMainMenu () {
        System.out.println("\n\n====================================");
        System.out.println("\nHlavni menu");
        System.out.println("1. Prehled produktu");
        System.out.println("2. Sprava produktu");
        System.out.println("3. Prehled skladovych prostoru");
        System.out.println("4. Sprava skladovych prostoru");
        System.out.println("5. Vytvorit testovaci data");
        System.out.println("0. Ukoncit program");
        System.out.println("\n====================================");
    }

    /**
     * Vypíše menu pro správu produktů.
     */
    public void printProductsManagementMenu () {
        System.out.println("\n\n====================================");
        System.out.println("\nSprava produktu");
        System.out.println("1. Pridat produkt");
        System.out.println("2. Ulozit produkt do prostoru");
        System.out.println("3. Zmenit produkt");
        System.out.println("4. Smazat produkt");
        System.out.println("0. Zpet");
        System.out.println("\n====================================");
    }

    /**
     * Vypíše menu pro správu skladů.
     */
    public void printStorageManagementMenu () {
        System.out.println("\n\n====================================");
        System.out.println("\nSprava skladovych prostoru");
        System.out.println("1. Pridat prostor");
        System.out.println("2. Spravovat ulozene produkty v prostoru");
        System.out.println("3. Zmenit prostor");
        System.out.println("4. Smazat prostor");
        System.out.println("0. Zpet");
        System.out.println("\n====================================");
    }
}
