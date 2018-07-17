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

import com.blibli.oss.common.helper.constants.Comparator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static com.blibli.oss.common.helper.NumberHelper.is;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class NumberHelperTest {

  private static final BigDecimal BD_ONE = new BigDecimal(1);
  private static final BigDecimal BD_TWO = new BigDecimal(2);

  private static final Long L_ONE = 1L;
  private static final Long L_TWO = 2L;

  private static final Double D_ONE = 1.1;
  private static final Double D_TWO = 2.2;

  private static final Integer INT_ONE = 1;
  private static final Integer INT_TWO = 2;

  @Test
  public void is_bigDecimalNullInput_returnsFalse() {
    BigDecimal num1 = null;
    BigDecimal num2 = null;

    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = BD_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = null;
    num2 = BD_TWO;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);
  }

  @Test
  public void is_bigDecimalGT() {
    BigDecimal num1 = BD_ONE;
    BigDecimal num2 = BD_TWO;
    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = BD_ONE;
    num2 = BD_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = BD_TWO;
    num2 = BD_ONE;
    result = is(num1, Comparator.GT, num2);
    assertTrue(result);
  }

  @Test
  public void is_bigDecimalGTE() {
    BigDecimal num1 = BD_ONE;
    BigDecimal num2 = BD_TWO;
    boolean result = is(num1, Comparator.GTE, num2);
    assertFalse(result);

    num1 = BD_ONE;
    num2 = BD_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);

    num1 = BD_TWO;
    num2 = BD_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);
  }

  @Test
  public void is_bigDecimalLT() {
    BigDecimal num1 = BD_ONE;
    BigDecimal num2 = BD_TWO;
    boolean result = is(num1, Comparator.LT, num2);
    assertTrue(result);

    num1 = BD_ONE;
    num2 = BD_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);

    num1 = BD_TWO;
    num2 = BD_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);
  }

  @Test
  public void is_bigDecimalLTE() {
    BigDecimal num1 = BD_ONE;
    BigDecimal num2 = BD_TWO;
    boolean result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = BD_ONE;
    num2 = BD_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = BD_TWO;
    num2 = BD_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertFalse(result);
  }

  @Test
  public void is_bigDecimalEQ() {
    BigDecimal num1 = BD_ONE;
    BigDecimal num2 = BD_TWO;
    boolean result = is(num1, Comparator.EQ, num2);
    assertFalse(result);

    num1 = BD_ONE;
    num2 = BD_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = BD_TWO;
    num2 = BD_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertFalse(result);
  }

  @Test
  public void is_bigDecimalNEQ() {
    BigDecimal num1 = BD_ONE;
    BigDecimal num2 = BD_TWO;
    boolean result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = null;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = BD_ONE;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = null;
    num2 = BD_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = BD_ONE;
    num2 = BD_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = BD_TWO;
    num2 = BD_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);
  }

  @Test
  public void is_doubleNullInput_returnsFalse() {
    Double num1 = null;
    Double num2 = null;

    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = D_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = null;
    num2 = D_TWO;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);
  }

  @Test
  public void is_doubleGT() {
    Double num1 = D_ONE;
    Double num2 = D_TWO;
    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = D_ONE;
    num2 = D_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = D_TWO;
    num2 = D_ONE;
    result = is(num1, Comparator.GT, num2);
    assertTrue(result);
  }

  @Test
  public void is_doubleGTE() {
    Double num1 = D_ONE;
    Double num2 = D_TWO;
    boolean result = is(num1, Comparator.GTE, num2);
    assertFalse(result);

    num1 = D_ONE;
    num2 = D_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);

    num1 = D_TWO;
    num2 = D_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);
  }

  @Test
  public void is_doubleLT() {
    Double num1 = D_ONE;
    Double num2 = D_TWO;
    boolean result = is(num1, Comparator.LT, num2);
    assertTrue(result);

    num1 = D_ONE;
    num2 = D_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);

    num1 = D_TWO;
    num2 = D_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);
  }

  @Test
  public void is_doubleLTE() {
    Double num1 = D_ONE;
    Double num2 = D_TWO;
    boolean result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = D_ONE;
    num2 = D_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = D_TWO;
    num2 = D_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertFalse(result);
  }

  @Test
  public void is_doubleEQ() {
    Double num1 = D_ONE;
    Double num2 = D_TWO;
    boolean result = is(num1, Comparator.EQ, num2);
    assertFalse(result);

    num1 = D_ONE;
    num2 = D_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = D_TWO;
    num2 = D_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertFalse(result);
  }

  @Test
  public void is_doubleNEQ() {
    Double num1 = D_ONE;
    Double num2 = D_TWO;
    boolean result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = null;
    num2 = D_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = D_ONE;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = null;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = D_ONE;
    num2 = D_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = D_TWO;
    num2 = D_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);
  }

  @Test
  public void is_intNullInput_returnsFalse() {
    Integer num1 = null;
    Integer num2 = null;

    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = INT_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = null;
    num2 = INT_TWO;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);
  }

  @Test
  public void is_intGT() {
    Integer num1 = INT_ONE;
    Integer num2 = INT_TWO;
    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = INT_ONE;
    num2 = INT_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = INT_TWO;
    num2 = INT_ONE;
    result = is(num1, Comparator.GT, num2);
    assertTrue(result);
  }

  @Test
  public void is_intGTE() {
    Integer num1 = INT_ONE;
    Integer num2 = INT_TWO;
    boolean result = is(num1, Comparator.GTE, num2);
    assertFalse(result);

    num1 = INT_ONE;
    num2 = INT_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);

    num1 = INT_TWO;
    num2 = INT_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);
  }

  @Test
  public void is_intLT() {
    Integer num1 = INT_ONE;
    Integer num2 = INT_TWO;
    boolean result = is(num1, Comparator.LT, num2);
    assertTrue(result);

    num1 = INT_ONE;
    num2 = INT_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);

    num1 = INT_TWO;
    num2 = INT_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);
  }

  @Test
  public void is_intLTE() {
    Integer num1 = INT_ONE;
    Integer num2 = INT_TWO;
    boolean result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = INT_ONE;
    num2 = INT_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = INT_TWO;
    num2 = INT_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertFalse(result);
  }

  @Test
  public void is_intEQ() {
    Integer num1 = INT_ONE;
    Integer num2 = INT_TWO;
    boolean result = is(num1, Comparator.EQ, num2);
    assertFalse(result);

    num1 = INT_ONE;
    num2 = INT_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = INT_TWO;
    num2 = INT_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertFalse(result);
  }

  @Test
  public void is_intNEQ() {
    Integer num1 = INT_ONE;
    Integer num2 = INT_TWO;
    boolean result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = INT_ONE;
    num2 = INT_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = null;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = null;
    num2 = INT_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = INT_ONE;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = INT_TWO;
    num2 = INT_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);
  }

  @Test
  public void is_longNullInput_returnsFalse() {
    Long num1 = null;
    Long num2 = null;

    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = L_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = null;
    num2 = L_TWO;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);
  }

  @Test
  public void is_longGT() {
    Long num1 = L_ONE;
    Long num2 = L_TWO;
    boolean result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = L_ONE;
    num2 = L_ONE;
    result = is(num1, Comparator.GT, num2);
    assertFalse(result);

    num1 = L_TWO;
    num2 = L_ONE;
    result = is(num1, Comparator.GT, num2);
    assertTrue(result);
  }

  @Test
  public void is_longGTE() {
    Long num1 = L_ONE;
    Long num2 = L_TWO;
    boolean result = is(num1, Comparator.GTE, num2);
    assertFalse(result);

    num1 = L_ONE;
    num2 = L_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);

    num1 = L_TWO;
    num2 = L_ONE;
    result = is(num1, Comparator.GTE, num2);
    assertTrue(result);
  }

  @Test
  public void is_longLT() {
    Long num1 = L_ONE;
    Long num2 = L_TWO;
    boolean result = is(num1, Comparator.LT, num2);
    assertTrue(result);

    num1 = L_ONE;
    num2 = L_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);

    num1 = L_TWO;
    num2 = L_ONE;
    result = is(num1, Comparator.LT, num2);
    assertFalse(result);
  }

  @Test
  public void is_longLTE() {
    Long num1 = L_ONE;
    Long num2 = L_TWO;
    boolean result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = L_ONE;
    num2 = L_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertTrue(result);

    num1 = L_TWO;
    num2 = L_ONE;
    result = is(num1, Comparator.LTE, num2);
    assertFalse(result);
  }

  @Test
  public void is_longEQ() {
    Long num1 = L_ONE;
    Long num2 = L_TWO;
    boolean result = is(num1, Comparator.EQ, num2);
    assertFalse(result);

    num1 = L_ONE;
    num2 = L_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertTrue(result);

    num1 = L_TWO;
    num2 = L_ONE;
    result = is(num1, Comparator.EQ, num2);
    assertFalse(result);
  }

  @Test
  public void is_longNEQ() {
    Long num1 = L_ONE;
    Long num2 = L_TWO;
    boolean result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = L_ONE;
    num2 = L_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = null;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertFalse(result);

    num1 = null;
    num2 = L_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = L_ONE;
    num2 = null;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);

    num1 = L_TWO;
    num2 = L_ONE;
    result = is(num1, Comparator.NEQ, num2);
    assertTrue(result);
  }

  @Test
  public void parseDouble_invalidStringAndSuppressException_returnsZero() {
    double result = NumberHelper.parseDouble("5,0", NumberHelper.ParseMode.SUPPRESS_EXCEPTION);
    assertEquals(0.0, result);
  }

  @Test(expected = NumberFormatException.class)
  public void parseDouble_invalidStringAndStrictMode_propagatesException() {
    NumberHelper.parseDouble("5,0", NumberHelper.ParseMode.STRICT);
  }

  @Test
  public void parseDouble_validString_returnsDouble() {
    double result = NumberHelper.parseDouble("5.0", NumberHelper.ParseMode.STRICT);
    assertEquals(5.0, result);
  }

  @Test
  public void parseLong_invalidStringAndSuppressException_returnsZero() {
    long result = NumberHelper.parseLong("5,0", NumberHelper.ParseMode.SUPPRESS_EXCEPTION);
    assertEquals(0L, result);
  }

  @Test(expected = NumberFormatException.class)
  public void parseLong_invalidStringAndStrictMode_propagatesException() {
    NumberHelper.parseLong("5,0", NumberHelper.ParseMode.STRICT);
  }

  @Test
  public void parseLong_validString_returnsLong() {
    long result = NumberHelper.parseLong("5", NumberHelper.ParseMode.STRICT);
    assertEquals(5L, result);
  }

  @Test
  public void parseInt_invalidStringAndSuppressException_returnsZero() {
    int result = NumberHelper.parseInt("5,0", NumberHelper.ParseMode.SUPPRESS_EXCEPTION);
    assertEquals(0, result);
  }

  @Test(expected = NumberFormatException.class)
  public void parseInt_invalidStringAndStrictMode_propagatesException() {
    NumberHelper.parseInt("5,0", NumberHelper.ParseMode.STRICT);
  }

  @Test
  public void parseInt_validString_returnsInteger() {
    int result = NumberHelper.parseInt("5", NumberHelper.ParseMode.STRICT);
    assertEquals(5, result);
  }

  @Before
  public void setUp() {
    new NumberHelper();
  }
}
