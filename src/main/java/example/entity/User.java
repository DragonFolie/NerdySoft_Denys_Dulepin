package example.entity;

import example.entity.product.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

  private String name;
  private int age;

  public static User createUser(String name, int age) {
    User user = new User();
    user.setName(name);
    user.setAge(age);
    return user;
  }


  public static double calculateAverageAge(Product product, List<Order> orders) {
    List<Integer> listOfAge = new ArrayList<>();
    for (Order order : orders) {
      if (order.getProducts().contains(product)) {
        listOfAge.add(order.getUser().getAge());
      }
    }
    return listOfAge.stream().mapToInt(val -> val).average().orElse(0.0);
  }


  public static List<Order> sortOrdersByUserAgeDesc(List<Order> orders) {
    List<Order> sortedListOfOrders = new ArrayList<>(orders);
    Collections.sort(sortedListOfOrders, (value1, value2) -> Integer.compare(value2.getUser().getAge(), value1.getUser().getAge()));
    return sortedListOfOrders;
  }


  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

}
