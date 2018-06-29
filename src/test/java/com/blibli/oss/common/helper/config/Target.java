/*
 * Copyright 2018 BLIBLI.COM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
