package store;

import java.math.BigDecimal;
import java.util.*;

/**
 * Cart.java
 *
 * @author Fan Chen Created on Jan 17, 2012
 *
 * A shopping cart
 */
public class Cart {

    private HashMap<Item, Integer> contents;

    /**
     * constructor
     */
    public Cart() {
        contents = new HashMap<Item, Integer>();
    }

    /**
     * add item in cart
     *
     * @param itemCode
     */
    public void addItem(String itemCode) {
        Catalog catalog = new Catalog();

        if (catalog.containsItem(itemCode)) {
            Item item = catalog.getItem(itemCode);

            int newQuantity = 1;
            if (contents.containsKey(item)) {
                Integer currentQuantity = contents.get(item);
                newQuantity += currentQuantity.intValue();
            }

            contents.put(item, new Integer(newQuantity));
        }
    }

    /**
     * remove item from cart
     *
     * @param itemCode
     */
    public void removeItems(String itemCode) {

        Catalog catalog = new Catalog();
        if (catalog.containsItem(itemCode)) {
            Item item = catalog.getItem(itemCode);
            if (contents.containsKey(item)) {
                int currentQuantity = contents.get(item);

                currentQuantity--;

                if (currentQuantity == 0) {
                    contents.remove(item);
                } else {
                    contents.put(item, currentQuantity);
                }
            }

        }

    }

    /**
     *
     * @return sb representation of cart contents
     */
    public String toJson() {

        
        // {"cart":{"generated":1327548501972, "total":$179.97, "item":[{"name":"hat","quantity":2},{"name":"dog","quantity:1"} ] }}
        
        StringBuilder sb = new StringBuilder();
        sb.append("{\"cart\":");
        sb.append("{\"generated\":"+System.currentTimeMillis()+", \"total\":"+getCartTotal()+", \"item\":[");
        
        if(contents.isEmpty())
        {
            sb.append("]}}");
            return sb.toString();
        }
        
        Set<Item> items = contents.keySet();
        for (Item item : items) {
            Object value = contents.get(item).intValue();
            sb.append("{\"name\":\"");
            sb.append(item.getName());
            sb.append("\",\"quantity\":");
            //quantity
            sb.append(value.toString());
            sb.append("},");
        }
        sb.setCharAt(sb.length()-1, ']');
        sb.append("}}");
            
            
        System.out.println(sb.toString());
        
        
        return sb.toString();
    }

    private String getCartTotal() {
        int total = 0;

        for (Iterator<Item> I = contents.keySet().iterator(); I.hasNext();) {
            Item item = I.next();
            int itemQuantity = contents.get(item).intValue();

            total += (item.getPrice() * itemQuantity);
        }

        return "$" + new BigDecimal(total).movePointLeft(2);
    }

}
