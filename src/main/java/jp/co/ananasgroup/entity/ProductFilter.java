package jp.co.ananasgroup.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by shmily on 2016/8/31.
 */
@Getter
public class ProductFilter {

  private final String filterText;

  private final boolean inStockOnly;

  @JsonCreator
  public ProductFilter(@JsonProperty("filterText") String filterText,
                 @JsonProperty("inStockOnly") boolean inStockOnly) {
    this.filterText = filterText;
    this.inStockOnly = inStockOnly;
  }

  @Override
  public String toString() {
    return "ProductFilter{" +
        "filterText='" + filterText + '\'' +
        ", inStockOnly=" + inStockOnly +
        '}';
  }
}
