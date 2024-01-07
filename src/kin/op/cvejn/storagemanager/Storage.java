package kin.op.cvejn.storagemanager;

import java.util.Arrays;

/**
 *
 * @author Daniel Cvejn
 */
public class Storage {
    public int size;
    public Product[] storedProducts;
    public int coordinateX;
    public int coordinateY;
    public static Storage[] storagesList;

    /**
     * @param size Velikost úložného prostoru
     * @param x Číslo sloupce
     * @param y Číslo řádku
     */
    public Storage(int size, int x, int y) {
        this.size = size;
        this.coordinateX = x;
        this.coordinateY = y;
        this.storedProducts = null;

        if (storagesList == null) {
            storagesList = new Storage[1];
            storagesList[0] = this;
        } else {
            Storage[] newStoragesList = new Storage[storagesList.length + 1];
            System.arraycopy(storagesList, 0, newStoragesList, 0, storagesList.length);
            newStoragesList[storagesList.length] = this;
            storagesList = newStoragesList;
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * @param size Nová velikost prostoru
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * @param coordinateX Nový sloupec umístění prostoru
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * @param coordinateY Nový řádek umístění prostoru
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    /**
     * @param product Produkt, který má být uložen do daného prostoru
     */
    public void storeProduct(Product product) {
        if (product.getStored()) {
            unstoreProduct(product);
            System.out.println("Produkt je jiz ulozen, proto bude presunut do noveho prostoru.");
        }
        if (this.storedProducts == null) {
            this.storedProducts = new Product[1];
            this.storedProducts[0] = product;
            product.setStored(true);
            System.out.println("Produkt " + product.getName() + " ulozen do tohoto prostoru (" + this.coordinateX + ", " + this.coordinateY + ")");
        } else if (this.storedProducts.length >= this.size) {
            System.out.println("Tento prostor je jiz plny");
        }else {
            Product[] newStoredProducts = new Product[this.storedProducts.length + 1];
            System.arraycopy(this.storedProducts, 0, newStoredProducts, 0, this.storedProducts.length);
            newStoredProducts[this.storedProducts.length] = product;
            this.storedProducts = newStoredProducts;
            product.setStored(true);
            System.out.println("Produkt " + product.getName() + " ulozen do tohoto prostoru (" + this.coordinateX + ", " + this.coordinateY + ")");
        }
    }

    /**
     * @param product Produkt, který má být odstraněn z daného prostoru
     */
    public void unstoreProduct(Product product) {
        if (this.storedProducts == null || this.storedProducts.length == 0) {
            return;
        }
        Product[] newStoredProducts = new Product[this.storedProducts.length];
        int i = 0;
        if (newStoredProducts.length == 0) {
            newStoredProducts = null;
        } else {
            for (Product storedProduct : this.storedProducts) {
                if (!storedProduct.getName().equals(product.getName())) {
                    newStoredProducts[i] = storedProduct;
                    i++;
                }
            }
        }
        this.storedProducts = Arrays.stream(newStoredProducts).filter(p -> p != null).toArray(Product[]::new);
    }

    /**
     * @param x Souřadnice x úložného prostoru, který chceme získat
     * @param y Souřadnice y úložného prostoru, který chceme získat
     */
    public static Storage getStorageByCoordinates(int x, int y) {
        for (Storage storage : storagesList) {
            if (storage.getCoordinateX() == x && storage.getCoordinateY() == y) {
                return storage;
            }
        }
        return null;
    }

    /**
     * @param x Souřadnice x úložného prostoru, který chceme smazat
     * @param y Souřadnice y úložného prostoru, který chceme smazat
     */
    public static void removeStorageByCoordinates(int x, int y) {
        Storage[] newStorageList = new Storage[storagesList.length - 1];
        int i = 0;
        for (Storage storage : storagesList) {
            if (storage.getCoordinateX() != x && storage.getCoordinateY() != y) {
                newStorageList[i] = storage;
                i++;
            }
        }
        storagesList = newStorageList;
    }
}
