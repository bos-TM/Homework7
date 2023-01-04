package Task3;

import java.util.*;

public class Price {
    String nameProduct;
    String nameShop;
    long priceUAH;

    public Price() {
    }
    public String getNameShop() {
        return nameShop;
    }

    public static void main(String[] args) {
        Price[] productsOfShops = { new Price(), new Price() };
        for (int i = 0; i < productsOfShops.length; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Введіть назву товару: ");
            productsOfShops[i].nameProduct = input.nextLine();
            System.out.print("Введіть назву магазину, в якому продається товар: ");
            productsOfShops[i].nameShop = input.nextLine();
            System.out.print("Введіть вартість товару в гривнях: ");
            try {
                productsOfShops[i].priceUAH = input.nextLong();
            } catch (Exception e) {
                System.out.println("Треба вводити лишень цифри.");
                System.out.println(e.getMessage());
            }
        }

        Arrays.sort(productsOfShops, Comparator.comparing(Price::getNameShop));

        {
            Scanner input = new Scanner(System.in);
            System.out.print("Введіть назву магазину, в якому продається товар: ");
            String shop = input.nextLine().toLowerCase();
            int numbersOfProduct = 0;
            for (Price element: productsOfShops) {
               if(element.nameShop.toLowerCase().contains(shop))
                   numbersOfProduct++;
            }
            System.out.println("Кількість товарі в магазині " + numbersOfProduct);

            String[] products;
            try {
                products = new String[numbersOfProduct];
                for (int i = 0; i < productsOfShops.length; i++) {
                    if(productsOfShops[i].nameShop.equalsIgnoreCase(shop))
                        products[i] = productsOfShops[i].nameProduct;
                }
                Arrays.sort(products);
                ArrayList productsOfShop = new ArrayList(List.of(products));
                System.out.println(productsOfShop);
            } catch (Exception e) {
                System.out.println("Такого магазину немає в базі.");
                System.out.println(e.getMessage());
            }
        }
    }
}
