package example.entity.product.factory.impl;

import example.entity.product.Product;
import java.time.LocalDate;

public class VirtualProduct extends Product {
  private String code;
  private LocalDate expirationDate;

  public VirtualProduct(String name, double price, String code, LocalDate expirationDate) {
    super(name, price);
    this.code = code;
    this.expirationDate = expirationDate;
  }

  public String getCode() {
    return code;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }
}