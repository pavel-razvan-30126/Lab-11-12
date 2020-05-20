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

    /*public UserCart() {
    }*/

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
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {
        int index = 0;

        for (Product product : cardProducts) {
            if (product.getProductId().equals(productId)) {
                index = cardProducts.indexOf(product);
                cardProducts.remove(index);
            }
        }
        if(index == 0){
            throw new ProductNotFoundException();
        }
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {

    }
}
