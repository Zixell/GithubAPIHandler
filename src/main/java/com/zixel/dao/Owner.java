package com.zixel.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
  private final String login;

  @JsonIgnoreProperties(ignoreUnknown = true)
  public Owner(
          @JsonProperty(value = "login") String login
  ) {
    this.login = login;

  }

  public String getLogin() {
    return login;
  }
}
