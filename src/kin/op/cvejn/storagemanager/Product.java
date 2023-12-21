package kin.op.cvejn.storagemanager;

/**
 *
 * @author Daniel Cvejn
 */
public class Product {
    public String name;
    public int price;
    public int count;
    public boolean stored;
    public static Product[] productsList;

    /**
     * @param name Název produktu
     * @param price Cena produktu
     * @param count Celkový počet kusů produktu
     */
    public Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;

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

    public String getName() {
        return this.name;
    }

    /**
     * @param newName Nový název produktu
     */
    public void setName(String newName) {
        this.name = newName;
    }

    public int getPrice() {
        return this.price;
    }

    /**
     * @param newPrice Nová cena produktu
     */
    public void setPrice(int newPrice) {
        String text;
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

    public int getCount() {
        return this.count;
    }

    /**
     * @param newCount Nový stav produktu na skladě
     */
    public void setCount(int newCount) {
        String text;
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

    public boolean getStored () {
        return this.stored;
    }

    public void setStored(boolean store) {
        this.stored = store;
    }

    public static Product getProductByName(String name) {
        for (Product product : productsList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public static void removeProductByName(String name) {
        Product[] newProductsList = new Product[productsList.length - 1];
        int i = 0;
        for (Product product : productsList) {
            if (!product.getName().equals(name)) {
                newProductsList[i] = product;
                i++;
            }
        }
        productsList = newProductsList;
    }
}
