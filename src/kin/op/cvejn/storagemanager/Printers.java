package kin.op.cvejn.storagemanager;

/**
 *
 * @author Daniel Cvejn
 */
public class Printers {
    public void printHead () {
        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|   Vitejte ve sprave skladu XXX   |");
        System.out.println("|                                  |");
        System.out.println("====================================");
    }

    public void printProducts () {
        System.out.println("\n\n====================================");
        System.out.println("\nPrehled vsech produktu");
        if (Product.productsList == null || Product.productsList.length == 0) {
            System.out.println("Zadne produkty nejsou vytvoreny.");
            System.out.println("\n====================================");
            return;
        }
        for (Product product : Product.productsList) {
            System.out.println(" - Produkt: " + product.getName());
            System.out.println("   - Cena: " + product.getPrice() + "Kc");
            System.out.println("   - Pocet kusu na sklade: " + product.getCount() + "ks");
        }
        System.out.println("\n====================================");
    }

    public void printStorage () {
        System.out.println("\n\n====================================");
        System.out.println("\nPrehled skladu");
        if (Storage.storagesList == null) {
            System.out.println("Zadne skladovaci prostory nejsou vytvoreny.");
            System.out.println("\n====================================");
            return;
        }
        int storedProductsLength;
        for (Storage storage : Storage.storagesList) {
            if (storage.storedProducts == null) storedProductsLength = 0;
            else storedProductsLength = storage.storedProducts.length;
            System.out.println(storage.getCoordinateY() + ". rada, " + storage.getCoordinateX() + ". sloupec");
            System.out.println(" - Vyuzito " + storedProductsLength + "/" + storage.getSize());
            System.out.println(" - Produkty:");
            for (Product storedProduct : storage.storedProducts) {
                System.out.println("   - " + storedProduct.getName());
            }
        }
        System.out.println("\nNeulozene produkty");
        for (Product product : Product.productsList) {
            if (!product.getStored()) {
                System.out.println(product.getName());
            }
        }
        System.out.println("\n====================================");
    }

    public void printProductsList () {
        System.out.println("\nSeznam produktu");
        if (Product.productsList == null) {
            System.out.println("Zadne produkty nejsou vytvoreny.");
            return;
        }
        for (int i = 0; i < Product.productsList.length; i++) {
            System.out.println(i + 1 + ". " + Product.productsList[i].getName());
        }
    }

    public void printMainMenu () {
        System.out.println("\n\n====================================");
        System.out.println("\nHlavni menu");
        System.out.println("1. Prehled produktu");
        System.out.println("2. Sprava produktu");
        System.out.println("3. Prehled skladu");
        System.out.println("4. Sprava skladovych prostoru");
        System.out.println("0. Ukoncit program");
        System.out.println("\n====================================");
    }

    public void printProductsManagementMenu () {
        System.out.println("\n\n====================================");
        System.out.println("\nSprava produktu");
        System.out.println("1. Pridat produkt");
        System.out.println("2. Zmenit produkt");
        System.out.println("3. Smazat produkt");
        System.out.println("0. Zpet");
        System.out.println("\n====================================");
    }

    public void printProductOverviewMenu () {
        printProductsList();
        System.out.println("0. Zrusit");
        System.out.println("\n====================================");
    }
}
