package aut.utcluj.isp.ex4;

import java.util.ArrayList;

import java.util.List;


/**
 * @author stefan
 */
public class UserCart {
    private List<Product> cardProducts = new ArrayList<>();
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCardProducts() {
        return cardProducts;
    }

    public UserCart() {
        this.cardProducts = new ArrayList<>();
        this.totalPrice = 0;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            cardProducts.add(product);
            totalPrice = totalPrice + product.getPrice();
        }
        // totalPrice = totalPrice + product.getPrice() * quantity;
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) {
        try {
            tryRemovingProduct(productId);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tryRemovingProduct(final String productID) throws ProductNotFoundException {
        boolean found = false;
        for (Product product : cardProducts) {
            if (product.getProductId().equals(productID)) {
                cardProducts.remove(product);
                totalPrice -=product.getPrice();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProductNotFoundException();
        }
    }


    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        this.totalPrice = 0;
        this.cardProducts = new ArrayList<>();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCardProducts(List<Product> cardProducts) {
        this.cardProducts = cardProducts;
    }
}
