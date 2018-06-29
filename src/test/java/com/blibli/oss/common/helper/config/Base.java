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
