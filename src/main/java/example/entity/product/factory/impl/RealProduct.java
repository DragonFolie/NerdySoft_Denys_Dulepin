package example.entity.product.factory.impl;

import example.entity.product.Product;
import lombok.Getter;

@Getter
public class RealProduct extends Product {
  private final int size;
  private final int weight;

  public RealProduct(String name, double price, int size, int weight) {
    super(name, price);
    this.size = size;
    this.weight = weight;
  }

}

