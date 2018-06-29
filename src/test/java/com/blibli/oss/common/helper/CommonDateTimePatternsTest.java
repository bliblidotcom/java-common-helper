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

package com.blibli.oss.common.helper;

import com.blibli.oss.common.helper.constants.CommonDateTimePatterns;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by william.s.setiadi on 6/26/2018.
 */
public class CommonDateTimePatternsTest {

  private CommonDateTimePatterns commonPatterns;

  @Test
  public void toString_commonDateTimePatterns_returnsFormattedDate() {
    Date date = new DateTime(2018, 06, 15, 23, 59, 40, 307).toDate();

    String result = DateHelper.toString(date, commonPatterns.dd_MM_yy);
    assertEquals("15-06-18", result);

    result = DateHelper.toString(date, commonPatterns.dd_MM_yyyy);
    assertEquals("15-06-2018", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy);
    assertEquals("15 Jun 2018", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy__HH_mm);
    assertEquals("15 Jun 2018 23:59", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy__hh_mm_a);
    assertEquals("15 Jun 2018 11:59 PM", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy__HH_mm_ss);
    assertEquals("15 Jun 2018 23:59:40", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy__hh_mm_ss_a);
    assertEquals("15 Jun 2018 11:59:40 PM", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy__HH_mm_ss_SSS);
    assertEquals("15 Jun 2018 23:59:40.307", result);

    result = DateHelper.toString(date, commonPatterns.dd_MMM_yyyy__hh_mm_ss_SSS_a);
    assertEquals("15 Jun 2018 11:59:40.307 PM", result);
  }

  @Before
  public void setUp() {
    commonPatterns = new CommonDateTimePatterns();
  }
}
