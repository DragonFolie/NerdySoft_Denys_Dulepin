package example.entity.product;

import example.entity.Order;
import example.entity.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

  private final String name;
  private final double price;


  public static List<Product> sortProductsByPrice(List<Product> products) {
    List<Product> sortedListOfProducts = new ArrayList<>(products);
    Collections.sort(sortedListOfProducts, Comparator.comparingDouble(Product::getPrice));
    return sortedListOfProducts;
  }

  public static Map<Product, List<User>> getProductUserMap(List<Order> orders) {
    Map<Product, List<User>> productUserMap = new HashMap<>();

    for (Order order : orders) {
      List<Product> products = order.getProducts();
      User user = order.getUser();
      for (Product product : products) {
        List<User> users = productUserMap.getOrDefault(product, new ArrayList<>());
        users.add(user);
        productUserMap.put(product, users);
      }
    }
    return productUserMap;
  }

  public static Product getMostPopularProduct(List<Order> orders) {
    Product mostPopularProduct = null;
    Map<Product, Integer> frequencyMap = new HashMap<>();

    for (Order order : orders) {
      List<Product> products = order.getProducts();
      for (Product product : products) {
        int count = frequencyMap.getOrDefault(product, 0);
        frequencyMap.put(product, count + 1);
      }
    }
    Integer frequencyValue = frequencyMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
    for (Map.Entry<Product, Integer> entry : frequencyMap.entrySet()) {
      if (frequencyValue.equals(entry.getValue())) {
        mostPopularProduct = entry.getKey();
      }
    }
    return mostPopularProduct;
  }


  public static Product getMostExpensiveProductPrice(List<Order> orders) {
    Product mostExpensiveProduct = null;
    double highestPrice = 0.0;
    for (Order order : orders) {
      for (Product product : order.getProducts()) {
        double price = product.getPrice();
        if (price > highestPrice) {
          highestPrice = price;
          mostExpensiveProduct = product;
        }
      }
    }
    return mostExpensiveProduct;
  }


  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}