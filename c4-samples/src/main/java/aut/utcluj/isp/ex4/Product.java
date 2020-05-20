package aut.utcluj.isp.ex4;

import java.util.Objects;

/**
 * @author stefan
 */
public class Product {
    private String productId;
    private Double price;

    public Product(String productId, Double price) {
        this.productId = productId;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", price=" + price +
                '}';
    }
}
