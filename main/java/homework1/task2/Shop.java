package homework1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * Мы хотим улучшить функциональность нашего интернет-магазина.
 * Ваша задача - добавить два новых метода в класс Shop:
 * Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
 * Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
 * Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
 * (правильное количество продуктов, верное содержимое корзины).
 * Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
 * Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
 * Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
 */
public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     *
     * @return sortedList - отсортированная, по возрастанию цены, копия начального списка продуктов
     */
    public List<Product> sortProductsByPrice() {
        if (products == null || products.size() == 0) return null;

        List<Product> sortedList = new ArrayList<>(products);
//        sortedList.sort((o1, o2) -> o1.getCost() - o2.getCost());  //
        sortedList.sort(Comparator.comparingInt(Product::getCost));
        return sortedList;
    }

    /**
     *
     * @return Продукт с наибольшей стоимостью или null - если список продуктов равен null или пустой
     */
    public Product getMostExpensiveProduct() {
        if (products == null || products.size() == 0) return null;

        Product mostExpensiveProduct = new Product(0, "");
        for (Product product : products) {
            if (product.getCost() > mostExpensiveProduct.getCost()) {
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

//    public static void main(String[] args) {
//        Shop shop = new Shop();
//        shop.setProducts(Arrays.asList(
//                new Product(10, "Milk"),
//                new Product(1, "matches"),
//                new Product(20, "chicken")
//        ));
//        Product expensiveProduct = shop.getMostExpensiveProduct();
//        System.out.println(expensiveProduct);
//        System.out.println(shop.sortProductsByPrice());
//    }
}

class ShopTest {
    public static void main(String[] args) {
        // валидный экземпляр Магазина для проверки всех тестов
        Shop validShop = new Shop();
        validShop.setProducts(Arrays.asList(
                new Product(10, "Milk"),
                new Product(1, "matches"),
                new Product(20, "chicken")
        ));

        // Невалидный магазин с пустым списком продуктов (size = 0)
        Shop notValidShopProductsEmpty = new Shop();
        notValidShopProductsEmpty.setProducts(Arrays.asList());
        // Невалидный магазин с отсутствующим списком продуктов (null)
        Shop notValidShopProductsNull = new Shop();

        // Не знаю правильно ли я понял про тест на проверку верного списка продуктов
        // но других идей у меня нет
        assertThat(validShop.getProducts()).contains(
                new Product(1, "matches"),
                new Product(10, "Milk"),
                new Product(20, "chicken")
        );
        assertThat(notValidShopProductsEmpty.getProducts()).isEmpty();
        assertThat(notValidShopProductsNull.getProducts()).isNull();

        // тесты на проверку самого дорогого товара
        assertThat(validShop.getMostExpensiveProduct().getCost()).isEqualTo(20);
        assertThat(notValidShopProductsEmpty.getMostExpensiveProduct()).isNull();
        assertThat(notValidShopProductsNull.getMostExpensiveProduct()).isNull();

        // тесты на проверку сортировки продуктов
        assertThat(validShop.sortProductsByPrice()).isEqualTo(Arrays.asList(
                new Product(1, "matches"),
                new Product(10, "Milk"),
                new Product(20, "chicken")
        ));
        assertThat(notValidShopProductsEmpty.sortProductsByPrice()).isNull();
        assertThat(notValidShopProductsNull.sortProductsByPrice()).isNull();
    }
}
