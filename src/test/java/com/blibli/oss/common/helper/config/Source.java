package com.blibli.oss.common.helper.config;

public class Source extends Base {

  private int intField;
  private double doubleField;
  private String stringField;
  private SampleEnum sampleEnum;

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

    Source source = (Source) o;

    if (intField != source.intField) {
      return false;
    }
    if (Double.compare(source.doubleField, doubleField) != 0) {
      return false;
    }
    if (stringField != null ?
        !stringField.equals(source.stringField) :
        source.stringField != null) {
      return false;
    }
    return sampleEnum == source.sampleEnum;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    result = 31 * result + intField;
    temp = Double.doubleToLongBits(doubleField);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (stringField != null ? stringField.hashCode() : 0);
    result = 31 * result + (sampleEnum != null ? sampleEnum.hashCode() : 0);
    return result;
  }

  public Source() {

  }

  public Source(int intField, double doubleField, String stringField, SampleEnum sampleEnum) {
    this.intField = intField;
    this.doubleField = doubleField;
    this.stringField = stringField;
    this.sampleEnum = sampleEnum;
  }

  public int getIntField() {
    return intField;
  }

  public void setIntField(int intField) {
    this.intField = intField;
  }

  public double getDoubleField() {
    return doubleField;
  }

  public void setDoubleField(double doubleField) {
    this.doubleField = doubleField;
  }

  public String getStringField() {
    return stringField;
  }

  public void setStringField(String stringField) {
    this.stringField = stringField;
  }

  public SampleEnum getSampleEnum() {
    return sampleEnum;
  }

  public void setSampleEnum(SampleEnum sampleEnum) {
    this.sampleEnum = sampleEnum;
  }
}
