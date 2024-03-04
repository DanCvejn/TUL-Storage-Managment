package kin.op.cvejn.storagemanager;

/**
 * Třída na vytváření a práci s produkty
 * @author Daniel Cvejn
 */
public class Product {

    public String name;
    public int price;
    public int count;
    public boolean stored;
    private static Product[] productsList;

    /**
     * Konstruktor produktů
     * @param name Název produktu
     * @param price Cena produktu
     * @param count Celkový počet kusů produktu
     */
    public Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.stored = false;

        if (productsList == null) {
            productsList = new Product[1];
            productsList[0] = this;
        } else {
            Product[] newProductsList = new Product[productsList.length + 1];
            System.arraycopy(productsList, 0, newProductsList, 0, productsList.length);
            newProductsList[productsList.length] = this;
            productsList = newProductsList;
        }
    }

    /**
     * Metoda pro získání seznamu všech produktů
     * @return Seznam produktů
     */
    public static Product[] getProductList() {
        return productsList;
    }

    /**
     * Metoda pro změnu seznamu produktů
     * @param newProductsList Nový seznam produktů
     */
    public static void setProductList(Product[] newProductsList) {
        productsList = newProductsList;
    }

    /**
     * Metoda pro vrácení názvu produktu
     * @return Název produktu
     */
    public String getName() {
        return this.name;
    }

    /**
     * Metoda pro změnu názvu produktu
     * @param newName Nový název produktu
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Metoda pro vrácení ceny produktu
     * @return Cena produktu
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Metoda pro změnu ceny produktu, cena musí být větší než 0
     * @param newPrice Nová cena produktu
     */
    public void setPrice(int newPrice) {
        String text;
        if (newPrice < 1) {
            System.out.println("Cena produktu " + this.name + " musi byt vetsi nez 0.");
            return;
        }
        if (this.price == newPrice) {
            System.out.println("Cena produktu " + this.name + " zustala stejna.");
            return;
        }
        if (this.price > newPrice) {
            text = "Cena produktu " + this.name + " se snizila z " + this.price + "Kc na ";
        } else {
            text = "Cena produktu " + this.name + " se zvysila z " + this.price + "Kc na ";
        }
        this.price = newPrice;
        System.out.println(text + this.price);
    }

    /**
     * Metoda pro vrácení počtu kusů produktu na skladě
     * @return Počet kusů produktu na skladě
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Metoda pro změnu počtu kusů produktu na skladě, počet kusů musí být větší nebo rovno 0
     * @param newCount Nový stav produktu na skladě
     */
    public void setCount(int newCount) {
        String text;
        if (newCount < 0) {
            System.out.println("Pocet kusu produktu " + this.name + " musi byt vetsi nebo roven 0.");
            return;
        }
        if (this.count == newCount) {
            System.out.println("Stav produktu " + this.name + " zustal stejny.");
            return;
        }
        if (this.count > newCount) {
            text = "Produktu " + this.name + " bylo prodano/vyskladneno " + (this.count - newCount) + ", novy stav je: ";
        } else {
            text = "Produkt " + this.name + " byl naskladnen o " + (newCount - this.count) + ", novy stav je: ";
        }
        this.count = newCount;
        System.out.println(text + this.count);
    }

    /**
     * Metoda pro vrácení stavu uložení produktu
     * @return Stav uložení produktu
     */
    public boolean getStored() {
        return this.stored;
    }

    /**
     * @param store Změna stavu uložení produktu
     */
    public void setStored(boolean store) {
        this.stored = store;
    }

    /**
     * Vrací produkt podle názvu
     * @param name Název produktu, který chceme získat
     * @return Produkt podle názvu
     */
    public static Product getProductByName(String name) {
        for (Product product : productsList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Odstraní produkt podle názvu
     * @param name Název produktu, který chceme odstranit
     */
    public static void removeProductByName(String name) {
        Product[] newProductsList = new Product[productsList.length - 1];
        int i = 0;
        for (Product product : productsList) {
            if (!product.getName().equals(name)) {
                newProductsList[i] = product;
                i++;
            } else if (product.getStored()) {
                Storage.findStorageByProduct(product).unstoreProduct(product);
            }
        }
        productsList = newProductsList;
    }
}
