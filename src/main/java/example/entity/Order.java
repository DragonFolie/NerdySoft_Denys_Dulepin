package example.entity;

import example.entity.product.Product;
import example.entity.product.factory.impl.RealProduct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;


@Getter
public final class Order {

  private final User user;
  private final List<Product> products;


  private Order(User user, List<Product> products) {
    this.user = user;
    this.products = products;
  }


  public static Order createOrder(User user, List<Product> products) {
    return new Order(user, products);
  }


  public static Map<Order, Integer> calculateWeightOfEachOrder(List<Order> orders) {
    Map<Order, Integer> calculatedWeight = new HashMap<>();
    for (Order order : orders) {
      int totalWeight = 0;
      for (Product product : order.getProducts()) {
        if (product instanceof RealProduct) {
          RealProduct realProduct = (RealProduct) product;
          totalWeight += realProduct.getWeight();
        }
      }
      calculatedWeight.put(order, totalWeight);
    }
    return calculatedWeight;
  }

  @Override
  public String toString() {
    return "Order{" +
        "user=" + user +
        ", products=" + products +
        '}';
  }
}
