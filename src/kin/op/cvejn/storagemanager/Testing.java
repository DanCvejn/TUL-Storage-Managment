package kin.op.cvejn.storagemanager;

import java.util.Random;

/**
 *
 * @author Daniel Cvejn
 */

public class Testing {
  public void createTestData() {
        Random rand = new Random();

        // Vytvoření produktů
        Product jablko = new Product("Jablko", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product banan = new Product("Banan", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product mrkev = new Product("Mrkev", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product okurka = new Product("Okurka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product rajce = new Product("Rajce", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        Product hruska = new Product("Hruska", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Meloun", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Brokolice", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Celer", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Redkvicka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Svestka", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Tresen", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Brambora", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Cibule", rand.nextInt(46) + 5, rand.nextInt(651) + 50);
        new Product("Cesnek", rand.nextInt(46) + 5, rand.nextInt(651) + 50);

        // Vytvoření skladů
        Storage storage1 = new Storage(10, 1, 1);
        Storage storage2 = new Storage(5, 2, 1);
        Storage storage3 = new Storage(5, 3, 1);
        new Storage(10, 1, 2);
        new Storage(10, 2, 2);
        new Storage(7, 3, 2);

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
