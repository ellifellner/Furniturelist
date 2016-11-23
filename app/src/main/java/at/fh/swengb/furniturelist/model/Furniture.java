package at.fh.swengb.furniturelist.model;

import java.io.Serializable;

/**
 * Created by Elli on 22.11.2016.
 */

public class Furniture implements Serializable {

    private String name;
    private String category;
    private String address;
    private Double price;
    private String url;

    public Furniture() {
    }

    public Furniture(String name, String category, String address, Double price, String url) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.price = price;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Furniture furniture = (Furniture) o;

        if (name != null ? !name.equals(furniture.name) : furniture.name != null) return false;
        return category != null ? category.equals(furniture.category) : furniture.category == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(name).append(" ")
                .append(category)
                .append('\n')
                .append(address).append('\n')
                .append(price)
                .append(url);
        return sb.toString();
    }
}
