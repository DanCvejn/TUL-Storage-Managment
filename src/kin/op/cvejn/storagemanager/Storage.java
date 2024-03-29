package kin.op.cvejn.storagemanager;

import java.util.Arrays;

/**
 * Tato třída slouží k vytváření a práci s úložnými prostory
 * @author Daniel Cvejn
 */
public class Storage {

    public int id;
    public int size;
    public Product[] storedProducts;
    public int coordinateX;
    public int coordinateY;
    private static Storage[] storagesList;

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
            this.id = 1;
        } else {
            Storage[] newStoragesList = new Storage[storagesList.length + 1];
            this.id = storagesList[storagesList.length - 1].id + 1;
            System.arraycopy(storagesList, 0, newStoragesList, 0, storagesList.length);
            newStoragesList[storagesList.length] = this;
            storagesList = newStoragesList;
        }
    }

    /**
     * Metoda pro získání seznamu všech skladovacích prostorů
     * @return Seznam prostorů
     */
    public static Storage[] getStoragesList() {
        return storagesList;
    }

    /**
     * Metoda pro změnu seznamu prostorů
     * @param newStoragesList Nový seznam prostorů
     */
    public static void setStoragesList(Storage[] newStoragesList) {
        storagesList = newStoragesList;
    }

    /**
     * Metoda pro získání id prostoru
     * @return Id prostoru
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda pro vrácení velikosti prostoru
     * @return Velikost prostoru
     */
    public int getSize() {
        return size;
    }

    /**
     * Metoda pro změnu velikosti prostoru, pokud je nová velikost menší než počet produktů v prostoru nebo menší než 0 tak se velikost nezmění
     * @param size Nová velikost prostoru
     */
    public void setSize(int size) {
        if (size < 0) {
            System.out.println("Velikost prostoru musi byt kladna.");
            return;
        }
        if (this.storedProducts != null && this.storedProducts.length > size) {
            System.out.println("Velikost prostoru je mensi nez pocet produktu v nem ulozenych. Zmente nejdrive pocet produktu.");
            return;
        }
        this.size = size;
    }

    /**
     * Metoda pro vrácení sloupce (X) umístění prostoru
     * @return Souřadnice sloupce (X) umístění prostoru
     */
    public int getCoordinateX() {
        return coordinateX;
    }

    /**
     * Metoda na změnu sloupce (souřadnice X) umístění prostoru, pokud je nový sloupec menší než 0 nebo na daných souřadnicích již existuje skladový prostor tak se sloupec nezmění
     * @param coordinateX Nový sloupec umístění prostoru
     */
    public void setCoordinateX(int coordinateX) {
        if (coordinateX < 0) {
            System.out.println("Sloupec musi byt kladny.");
            return;
        }
        if (getStorageByCoordinates(coordinateX, this.coordinateY) != null) {
            System.out.println("Na těchto souřadnicích již existuje skladový prostor.");
            return;
        }
        this.coordinateX = coordinateX;
    }

    /**
     * Metoda na změnu řádku (souřadnice Y) umístění prostoru
     * @return Souřadnice řádku (Y) umístění prostoru
     */
    public int getCoordinateY() {
        return coordinateY;
    }

    /**
     * Metoda pro vrácení řádku (Y) umístění prostoru, pokud je nový řádek menší než 0 nebo na daných souřadnicích již existuje skladový prostor tak se řádek nezmění
     * @param coordinateY Nový řádek umístění prostoru
     */
    public void setCoordinateY(int coordinateY) {
        if (coordinateY < 0) {
            System.out.println("Radek musi byt kladny.");
            return;
        }
        if (getStorageByCoordinates(this.coordinateX, coordinateY) != null) {
            System.out.println("Na těchto souřadnicích již existuje skladový prostor.");
            return;
        }
        this.coordinateY = coordinateY;
    }

    /**
     * Metoda na uložení produktu do daného prostoru, pokud je prostor již plný nebo je produkt již uložen tak se produkt neuloží
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
            System.out.println("Produkt " + product.getName() + " ulozen do tohoto prostoru č." + this.id);
        } else if (this.storedProducts.length >= this.size) {
            System.out.println("Tento prostor je jiz plny");
        } else {
            Product[] newStoredProducts = new Product[this.storedProducts.length + 1];
            System.arraycopy(this.storedProducts, 0, newStoredProducts, 0, this.storedProducts.length);
            newStoredProducts[this.storedProducts.length] = product;
            this.storedProducts = newStoredProducts;
            product.setStored(true);
            System.out.println("Produkt " + product.getName() + " ulozen do tohoto prostoru č." + this.id);
        }
    }

    /**
     * Metoda na odstranění produktu z prostoru
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
        product.setStored(false);
        this.storedProducts = Arrays.stream(newStoredProducts).filter(p -> p != null).toArray(Product[]::new);
    }

    /**
     * Metoda na získání prostoru podle souřadnic
     * @param x Souřadnice sloupce
     * @param y Souřadnice řádku
     * @return Vrací prostor podle souřadnic
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
     * Metoda na získání prostoru podle id
     * @param id Id prostoru
     * @return Vrací prostor podle souřadnic
     */
    public static Storage getStorageById(int id) {
        for (Storage storage : storagesList) {
            if (storage.getId() == id) {
                return storage;
            }
        }
        return null;
    }

    /**
     * Metoda na odstranění prostoru podle souřadnic
     * @param id Id prostoru, který chceme odstranit
     */
    public static void removeStorageById(int id) {
        Storage storage = getStorageById(id);
        if (storage.storedProducts != null) {
            for (Product product : storage.storedProducts) {
                product.setStored(false);
            }
        }
        Storage[] newStorageList = new Storage[Storage.getStoragesList().length - 1];
        int i = 0;
        for (Storage storageTmp : Storage.getStoragesList()) {
            if (storageTmp.getId() != id) {
                newStorageList[i] = storageTmp;
                i++;
            }
        }
        Storage.setStoragesList(newStorageList);
    }

    /**
     * Metoda na získání prostoru podle produktu
     * @param product Produkt, podle kterého chceme získat prostor
     * @return Vrací prostor podle produktu
     */
    public static Storage findStorageByProduct(Product product) {
        for (Storage storage : storagesList) {
            if (storage.storedProducts != null) {
                for (Product storedProduct : storage.storedProducts) {
                    if (storedProduct.getName().equals(product.getName())) {
                        return storage;
                    }
                }
            }
        }
        return null;
    }
}
