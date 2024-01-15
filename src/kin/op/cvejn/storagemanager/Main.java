package kin.op.cvejn.storagemanager;

/**
 * Tento program slouží k evidenci skladů a produktů.
 * Umožňuje vytvářet skladové prostory a ukládat do nich produkty.
 * Produkty je možné vyhledávat podle názvu.
 * Skladové prostory je možné vyhledávat podle souřadnic.
 * @author Daniel Cvejn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menus menu = new Menus();
        menu.mainMenu();
    }
}
