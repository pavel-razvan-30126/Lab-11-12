package aut.utcluj.isp.ex4;

import javax.swing.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author stefan
 */
public class UserCart implements ICartDetails {
    private List<Product> cardProducts = new ArrayList<>();
    private double totalPrice;
    private HashMap<Product, Integer> produse = new HashMap<>();

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
        produse.put(product, quantity);
        // totalPrice = totalPrice + product.getPrice() * quantity;
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {

        tryRemovingProduct(productId);

    }

    public void tryRemovingProduct(final String productID) throws ProductNotFoundException {
        boolean found = false;
        for (Product product : cardProducts) {
            if (product.getProductId().equals(productID)) {
                cardProducts.remove(product);
                totalPrice -= product.getPrice();
                found = true;
                break;
            }
        }
        if (found == false) {
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

    @Override
    public String getCartDetails() {
        String mesaj = "";
        for (Map.Entry<Product, Integer> entry : produse.entrySet()) {
            mesaj = mesaj + ("Product id: " + entry.getKey().getProductId() + ", Items: " + entry.getValue() + '\n');
        }

        return mesaj + "Total price: " + totalPrice;
    }
}



