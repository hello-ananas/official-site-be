package jp.co.ananasgroup.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jp.co.ananasgroup.entity.serializer.MoneySerialize;

/**
 * Created by shmily on 16/7/16.
 */
public class Product {

    private final String id;

    private final String category;

    private final float price;

    private final boolean stocked;

    private final String name;

    @JsonCreator
    public Product(@JsonProperty("id") String id,
                   @JsonProperty("category") String category,
                   @JsonProperty("price") float price,
                   @JsonProperty("stocked") boolean stocked,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.stocked = stocked;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    @JsonSerialize(using = MoneySerialize.class)
    public float getPrice() {
        return price;
    }

    public boolean isStocked() {
        return stocked;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id='" + id + '\'' +
            ", category='" + category + '\'' +
            ", price=" + price +
            ", stocked=" + stocked +
            ", name='" + name + '\'' +
            '}';
    }
}
