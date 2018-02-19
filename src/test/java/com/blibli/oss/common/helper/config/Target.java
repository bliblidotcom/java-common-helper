package com.blibli.oss.common.helper.config;

public class Target extends Base {

  private int intField;
  private String stringField;

  public Target() {

  }

  public Target(int intField, String stringField) {
    this.intField = intField;
    this.stringField = stringField;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Target target = (Target) o;

    if (intField != target.intField) {
      return false;
    }
    return stringField != null ?
        stringField.equals(target.stringField) :
        target.stringField == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + intField;
    result = 31 * result + (stringField != null ? stringField.hashCode() : 0);
    return result;
  }

  public int getIntField() {
    return intField;
  }

  public void setIntField(int intField) {
    this.intField = intField;
  }

  public String getStringField() {
    return stringField;
  }

  public void setStringField(String stringField) {
    this.stringField = stringField;
  }
}
