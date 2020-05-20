package aut.utcluj.isp.ex4;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class User {
    private UserCart userCart;
    private Double userMoney;

    public User(Double userMoney) {
        this.userMoney = userMoney;
        userCart = new UserCart();
    }

    public UserCart getUserCart() {
        return userCart;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserCart(UserCart userCart) {
        this.userCart = userCart;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    /**
     * Add product to the cart
     *
     * @param product  - product to be added
     * @param quantity - quantity to be added
     */
    public void addProductToCart(Product product, int quantity) {
        userCart.addProductToCart(product, quantity);
    }

    /**
     * Remove product from cart
     * An {@link ProductNotFoundException} exception should be thrown if no product with desired productId is found
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) {

        userCart.removeProductFromCart(productId);
    }


//   public void tryRemovingProduct(final String productID) throws ProductNotFoundException {
//       /* boolean found = false;
//        for (Product product : userCart.getCardProducts()) {
//            if (product.getProductId().equals(productID)) {
//                userCart.removeProductFromCart(productID);
//                found = true;
//            }
//        }
//        if (!found) {
//            throw new ProductNotFoundException();
//        }*/
//       {
//           userCart.removeProductFromCart(productID);
//       }
//    }


    /**
     * Submit cart details
     * Total price of the products should be extracted from userMoney
     * If userMoney is less than total price of the products, an {@link NotEnoughMoneyException} exception will be thrown
     * If userMoney is greater or equal to the total price of the products, total price should be extracted from total money and cart to be reset to default values
     */
    public void submitCart() {
        try {
            removeMoney();
        } catch (NotEnoughMoneyException e) {
            System.out.println("Not enough money");
        }
    }

    public void removeMoney() throws NotEnoughMoneyException {
        if (userMoney < userCart.getTotalPrice()) {
            throw new NotEnoughMoneyException();
        } else {
            userMoney -= userCart.getTotalPrice();
            userCart.resetCart();
        }
    }
}

