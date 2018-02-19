package com.blibli.oss.common.helper.config;

/**
 * Created by william.s.setiadi on 11/20/2017.
 */
public enum SampleEnum {
  ENUM_ONE("Enum One"),
  ENUM_TWO("Enum Two"),
  ENUM_THREE("Enum Three");

  private final String description;

  private SampleEnum(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
