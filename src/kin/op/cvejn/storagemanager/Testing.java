package kin.op.cvejn.storagemanager;

import java.util.Random;

/**
 * Tato třída slouží k vytvoření testovacích dat.
 * @author Daniel Cvejn
 */
public class Testing {

    /**
     * Vytvoří testovací data. S daty se dále dá pracovat v programu.
     */
    public void createTestData() {
        // Smazání všech produktů a skladů
        Product.productsList = null;
        Storage.storagesList = null;

        Random rand = new Random();

        // Vytvoření produktů
        Product jablko = new Product("Jablko", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product banan = new Product("Banan", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product mrkev = new Product("Mrkev", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product okurka = new Product("Okurka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product rajce = new Product("Rajce", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product hruska = new Product("Hruska", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product tempProduct = new Product("Meloun", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Brokolice", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Celer", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Redkvicka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Svestka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Tresen", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Brambora", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Cibule", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = new Product("Cesnek", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        tempProduct = hruska;

        // Vytvoření skladů
        Storage storage1 = new Storage(10, 1, 1);
        Storage storage2 = new Storage(5, 2, 1);
        Storage storage3 = new Storage(5, 3, 1);
        Storage tempStorage = new Storage(10, 1, 2);
        tempStorage = new Storage(10, 2, 2);
        tempStorage = new Storage(7, 3, 2);
        tempStorage = storage3;

        // Naplnění skladů produkty
        storage1.storeProduct(jablko);
        storage2.storeProduct(banan);
        storage2.storeProduct(mrkev);
        tempStorage.storeProduct(okurka);
        tempStorage.storeProduct(rajce);
        tempStorage.storeProduct(tempProduct);
        storage1.storeProduct(tempProduct);
    }
}
