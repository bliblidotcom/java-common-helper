package com.blibli.oss.common.helper.config;

/**
 * Created by william.s.setiadi on 12/6/2017.
 */
public class Base {

  private String id;
  private boolean markForDelete;

  public Base() {

  }

  public Base(String id, boolean markForDelete) {
    this.id = id;
    this.markForDelete = markForDelete;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Base base = (Base) o;

    if (markForDelete != base.markForDelete) {
      return false;
    }
    return id != null ? id.equals(base.id) : base.id == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (markForDelete ? 1 : 0);
    return result;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isMarkForDelete() {
    return markForDelete;
  }

  public void setMarkForDelete(boolean markForDelete) {
    this.markForDelete = markForDelete;
  }
}
