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
