package kin.op.cvejn.storagemanager;

import java.util.Random;

/**
 * Tato třída slouží k vytvoření testovacích dat a otestování funkcionality programu.
 * @author Daniel Cvejn
 */
public class Testing {

    /**
     * Metoda pro vytvoření produktů v testovací trídě
     * @param name Název produktu
     * @param price Cena produktu
     * @param count Počet produktů na skladě
     * @return
     */
    private Product createNewProduct(String name, int price, int count) {
        Product createdProduct = new Product(name, price, count);
        return createdProduct;
    }

    /**
     * Metoda pro vytvoření skladovacích prostor v testovací trídě
     * @param capacity Kapacita prostoru
     * @param x Souřadnice X prostoru
     * @param y Souřadnice Y prostoru
     * @return
     */
    private Storage createNewStorage(int capacity, int x, int y) {
        Storage createdStorage = new Storage(capacity, x, y);
        return createdStorage;
    }

    /**
     * Vytvoří testovací data. S daty se dále dá pracovat v programu.
     */
    public void createTestData() {
        // Smazání všech produktů a skladů
        Product.setProductList(null);
        Storage.setStoragesList(null);

        Random rand = new Random();

        // Vytvoření produktů
        Product jablko = createNewProduct("Jablko", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product banan = createNewProduct("Banan", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product mrkev = createNewProduct("Mrkev", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product okurka = createNewProduct("Okurka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product rajce = createNewProduct("Rajce", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product hruska = createNewProduct("Hruska", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Meloun", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Brokolice", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Celer", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Redkvicka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Svestka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Tresen", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Brambora", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Cibule", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        createNewProduct("Cesnek", rand.nextInt(46) + 5, rand.nextInt(651) + 50);

        // Vytvoření skladů
        Storage storage1 = createNewStorage(10, 1, 1);
        Storage storage2 = createNewStorage(5, 2, 1);
        Storage storage3 = createNewStorage(5, 3, 1);
        createNewStorage(10, 1, 2);
        createNewStorage(10, 2, 2);
        createNewStorage(7, 3, 2);

        // Naplnění skladů produkty
        storage1.storeProduct(jablko);
        storage2.storeProduct(banan);
        storage2.storeProduct(mrkev);
        storage3.storeProduct(okurka);
        storage3.storeProduct(rajce);
        storage3.storeProduct(hruska);
        storage1.storeProduct(hruska);
    }
}
