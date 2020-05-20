package aut.utcluj.isp.ex3;

import java.util.*;

/**
 * @author stefan
 */
public class StockController {
    private Map<String, List<Product>> catalogue;

    public StockController() {
        this.catalogue = new HashMap<>();
    }

    public StockController(Map<String, List<Product>> catalogue) {
        this.catalogue = catalogue;
    }


    /**
     * Add product to catalogue
     *
     * @param product  - product information
     * @param quantity - number of times the product should be added
     * @apiNote: if products with the same products id already exists, assume that @param product has the same data
     */
    public void addProductToCatalogue(final Product product, final int quantity) {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }

        catalogue.put(product.getId(), products);
    }

    /**
     * Return catalogue information
     *
     * @return dictionary where the key is the product id and the value is an array of products with the same id
     */
    public Map<String, List<Product>> getCatalogue() {
        return catalogue;
    }

    /**
     * Return all the products with particular id
     *
     * @param productId - unique product id
     * @return - list of existing products with same id or null if not found
     */
    public List<Product> getProductsWithSameId(final String productId) {
        List<Product> products = new ArrayList<>();
        products = null;
        for (List<Product> list : catalogue.values()) {
            for (Product product : list) {
                if (product.getId().equals(productId)) {
                    products = list;
                    break;
                }
            }
        }
        return products;
    }

    /**
     * Get total number of products from catalogue
     *
     * @return
     */
    public int getTotalNumberOfProducts() {
        int total = 0;
        for (List<Product> list : catalogue.values()) {
            total += list.size();
        }
        return total;
    }

    /**
     * Remove all products with same product id
     *
     * @param productId - unique product id
     * @return true if at least one product was deleted or false instead
     */
    public boolean removeAllProductsWitProductId(final String productId) {
        for (List<Product> list : catalogue.values()) {
            for (Product product : list) {
                if (product.getId().equals(productId)) {
                    for (Object o : catalogue.keySet()) {
                        if (catalogue.get(o).equals(list)) {
                            catalogue.remove(o);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Update the price for all the products with same product id
     *
     * @param productId - unique product id
     * @param price     - new price to be added
     * @return true if at least one product was updated or false instead
     */
    public boolean updateProductPriceByProductId(final String productId, final Double price) {
        for (List<Product> list : catalogue.values()) {
            for (Product product : list) {
                if (product.getId().equals(productId)) {
                    product.setPrice(price);
                    return true;
                }
            }
        }

        return false;
    }
}
