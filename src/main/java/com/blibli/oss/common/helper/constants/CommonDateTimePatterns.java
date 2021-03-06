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

package com.blibli.oss.common.helper.constants;

/**
 * Common Date Time Patterns in conformity with {@link org.joda.time.format.DateTimeFormat}.
 *
 * Created by william.s.setiadi on 5/25/2018.
 */
public final class CommonDateTimePatterns {

  /**
   * Sample result: 29-01-17
   */
  public static final String dd_MM_yy = "dd-MM-yy";

  /**
   * Sample result: 29-01-2017
   */
  public static final String dd_MM_yyyy = "dd-MM-yyyy";

  /**
   * Sample result: 29 Jan 2017
   */
  public static final String dd_MMM_yyyy = "dd MMM yyyy";

  /**
   * Sample result: 29 Jan 2017 13:50
   */
  public static final String dd_MMM_yyyy__HH_mm = "dd MMM yyyy HH:mm";

  /**
   * Sample result: 29 Jan 2017 01:50 PM
   */
  public static final String dd_MMM_yyyy__hh_mm_a = "dd MMM yyyy hh:mm a";

  /**
   * Sample result: 29 Jan 2017 13:50:59
   */
  public static final String dd_MMM_yyyy__HH_mm_ss = "dd MMM yyyy HH:mm:ss";

  /**
   * Sample result: 29 Jan 2017 01:50:59 PM
   */
  public static final String dd_MMM_yyyy__hh_mm_ss_a = "dd MMM yyyy hh:mm:ss a";

  /**
   * Sample result: 29 Jan 2017 13:50:59.370
   */
  public static final String dd_MMM_yyyy__HH_mm_ss_SSS = "dd MMM yyyy HH:mm:ss.SSS";

  /**
   * Sample result: 29 Jan 2017 01:50:59.370 PM
   */
  public static final String dd_MMM_yyyy__hh_mm_ss_SSS_a = "dd MMM yyyy hh:mm:ss.SSS a";
}
