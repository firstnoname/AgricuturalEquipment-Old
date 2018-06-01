package se.is.agriculturalequipment.model;

import java.io.Serializable;

/**
 * Created by iFirst-PC on 31/10/2560.
 */

public class PartList implements Serializable {

    private int id;
    private String partname, partPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(String partPrice) {
        this.partPrice = partPrice;
    }
}
