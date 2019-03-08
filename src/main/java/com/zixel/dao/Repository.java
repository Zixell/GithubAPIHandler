package com.zixel.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

  private final Integer totalCount;

  private final List<Item> items;

  @JsonCreator
  public Repository(
          @JsonProperty(value = "total_count") Integer totalCount,
          @JsonProperty(value = "items") List<Item> items
  ) {
    this.totalCount = totalCount;
    this.items = items;
  }


  public Integer getTotalCount() {
    return totalCount;
  }

  public List<Item> getItems() {
    return items;
  }
}
