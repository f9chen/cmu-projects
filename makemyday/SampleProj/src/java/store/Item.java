package store;

import java.math.BigDecimal;

/**
 * Item.java
 * @author Fan Chen
 * Created on Jan 17, 2012
 * 
 * Represent the item in store.
 */
public class Item {
    private String code;
    private String name;
    private String description;
    private int price;

    public Item(String code, String name, String description, int price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getFormattedPrice(){
        return "$"+new BigDecimal(price).movePointLeft(2);
    }
    
    /**
     * 
     * @param o the one that needs to be compared with
     * @return whether these two objects are same
     */
    @Override
    public boolean equals(Object o){
        if (this== o)
            return true;
        if(this==null)
            return false;
        if(!(o instanceof Item))
            return false;
        return ((Item)o).getCode().equals(this.code);
    }
}
