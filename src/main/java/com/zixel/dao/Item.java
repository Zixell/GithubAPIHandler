package com.zixel.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
  private final String name;
  private final String fullName;
  private final Owner owner;

  public Item(
          @JsonProperty(value = "name") String name,
          @JsonProperty(value = "full_name") String fullName,
          @JsonProperty(value = "owner") Owner owner
  ) {
    this.name = name;
    this.fullName = fullName;
    this.owner = owner;
  }


  public String getName() {
    return name;
  }

  public String getFullName() {
    return fullName;
  }

  public Owner getOwner() {
    return owner;
  }
}
