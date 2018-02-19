package com.blibli.oss.common.helper;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

public class DateHelperTest {

  private static final String VALID_DATE_FORMAT_PATTERN = "dd-MMM-yyyy";

  @Test
  public void now_returnsNewInstanceOfDate() {
    Date actual = DateHelper.now();
    assertNotNull(actual);
  }

  @Test
  public void now_withPattern_returnsFormattedCurrentDate() {
    String formattedCurrentDate = DateHelper.now(VALID_DATE_FORMAT_PATTERN);
    assertTrue(StringUtils.isNotBlank(formattedCurrentDate));
  }

  @Before
  public void setUp() {

  }

  @After
  public void tearDown() {

  }

  @Test
  public void toDate_emptyStringEmptyPattern_returnsNull() {
    Date result = DateHelper.toDate(null, null);
    assertNull(result);
  }

  @Test
  public void toDate_emptyStringValidPattern_returnsNull() {
    Date result = DateHelper.toDate(null, VALID_DATE_FORMAT_PATTERN);
    assertNull(result);
  }

  @Test
  public void toDate_validStringEmptyPattern_returnsNull() {
    Date result = DateHelper.toDate("21-Mar-2017", null);
    assertNull(result);
  }

  @Test
  public void toDate_validStringValidPattern_returnsDate() {
    Date result = DateHelper.toDate("21-Mar-2017", VALID_DATE_FORMAT_PATTERN);
    assertNotNull(result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toDate_invalidStringValidPattern_returnsDate() {
    DateHelper.toDate("21-03-2017", VALID_DATE_FORMAT_PATTERN);
  }

  @Test
  public void toString_nullDateNullPattern_returnsNull() {
    String result = DateHelper.toString(null, null);
    assertTrue(StringUtils.isBlank(result));
  }

  @Test
  public void toString_nullDateValidPattern_returnsNull() {
    String result = DateHelper.toString(null, VALID_DATE_FORMAT_PATTERN);
    assertTrue(StringUtils.isBlank(result));
  }

  @Test(expected = IllegalArgumentException.class)
  public void toString_validDateInvalidPattern_throwsException() {
    DateHelper.toString(new Date(), "invalidpattern-dd-MMM-yyyy");
  }

  @Test
  public void toString_validDateValidPattern_returnsFormattedDate() {
    String result = DateHelper.toString(new Date(), VALID_DATE_FORMAT_PATTERN);
    assertTrue(StringUtils.isNotBlank(result));
  }
}
