package com.blibli.oss.common.helper;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static com.blibli.oss.common.helper.DateHelper.TimeUnit.DAYS;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.HOURS;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.MILLISECONDS;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.MINUTES;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.SECONDS;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

public class DateHelperTest {

  private static final String VALID_DATE_FORMAT_PATTERN = "dd-MMM-yyyy";

  private static final Date LESSER_DATE = new Date(1519130699000L);
  private static final Date GREATER_DATE = new Date(1519131815000L);

  @Test
  public void add_nullDate_returnsNull() {
    Date result = DateHelper.add(null, 10, DateHelper.TimeUnit.DAYS);
    assertNull(result);
  }

  @Test
  public void add_nullComparator_returnsDateAddedByDiffItself() {
    long dateInMs = 1519130699000L;
    Date date = new Date(dateInMs);

    Date result = DateHelper.add(date, 10, null);
    assertEquals(dateInMs + 10L, result.getTime());
  }

  @Test
  public void add_validInputs_returnsDateAddedByDiffConvertedToMs() {
    long dateInMs = 1519130699000L;
    Date date = new Date(dateInMs);
    long expectedDiffInMs = 2 * 24 * 60 * 60 * 1000;

    Date result = DateHelper.add(date, 2, DateHelper.TimeUnit.DAYS);
    assertEquals(dateInMs + expectedDiffInMs, result.getTime());
  }

  @Test
  public void minus_nullDate_returnsNull() {
    Date result = DateHelper.minus(null, 10, DateHelper.TimeUnit.DAYS);
    assertNull(result);
  }

  @Test
  public void minus_nullTimeUnit_returnsDateSubtractedByDiffItself() {
    long dateInMs = 1519130699000L;
    Date date = new Date(dateInMs);
    Date result = DateHelper.minus(date, 10, null);
    assertEquals(dateInMs - 10L, result.getTime());
  }

  @Test
  public void minus_valid_returnsDateSubtractedByDiffConvertedToMs() {
    long dateInMs = 1519130699000L;
    Date date = new Date(dateInMs);
    long expectedDiffInMs = 2 * 24 * 60 * 60 * 1000;

    Date result = DateHelper.minus(date, 2, DateHelper.TimeUnit.DAYS);
    assertEquals(dateInMs - expectedDiffInMs, result.getTime());
  }

  @Test
  public void is_nullFirstDate_returnsFalse() {
    boolean result = DateHelper.is(null, DateHelper.TimeComparator.BEFORE, GREATER_DATE);
    assertFalse(result);
  }

  @Test
  public void is_nullSecondDate_returnsFalse() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.BEFORE, null);
    assertFalse(result);
  }

  @Test
  public void is_nullComparator_returnsFalse() {
    boolean result = DateHelper.is(LESSER_DATE, null, GREATER_DATE);
    assertFalse(result);
  }

  @Test
  public void is_before() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.BEFORE, GREATER_DATE);
    assertTrue(result);

    result = DateHelper.is(GREATER_DATE, DateHelper.TimeComparator.BEFORE, LESSER_DATE);
    assertFalse(result);

    result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.BEFORE, LESSER_DATE);
    assertFalse(result);
  }

  @Test
  public void is_beforeOrEqualTo() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.BEFORE_OR_EQUAL_TO, GREATER_DATE);
    assertTrue(result);

    result = DateHelper.is(GREATER_DATE, DateHelper.TimeComparator.BEFORE_OR_EQUAL_TO, LESSER_DATE);
    assertFalse(result);

    result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.BEFORE_OR_EQUAL_TO, LESSER_DATE);
    assertTrue(result);
  }

  @Test
  public void is_equalTo() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.EQUAL_TO, GREATER_DATE);
    assertFalse(result);

    result = DateHelper.is(GREATER_DATE, DateHelper.TimeComparator.EQUAL_TO, LESSER_DATE);
    assertFalse(result);

    result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.EQUAL_TO, LESSER_DATE);
    assertTrue(result);
  }

  @Test
  public void is_notEqualTo() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.NOT_EQUAL_TO, GREATER_DATE);
    assertTrue(result);

    result = DateHelper.is(GREATER_DATE, DateHelper.TimeComparator.NOT_EQUAL_TO, LESSER_DATE);
    assertTrue(result);

    result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.NOT_EQUAL_TO, LESSER_DATE);
    assertFalse(result);
  }

  @Test
  public void is_after() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.AFTER, GREATER_DATE);
    assertFalse(result);

    result = DateHelper.is(GREATER_DATE, DateHelper.TimeComparator.AFTER, LESSER_DATE);
    assertTrue(result);

    result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.AFTER, LESSER_DATE);
    assertFalse(result);
  }

  @Test
  public void is_afterOrEqualTo() {
    boolean result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.AFTER_OR_EQUAL_TO, GREATER_DATE);
    assertFalse(result);

    result = DateHelper.is(GREATER_DATE, DateHelper.TimeComparator.AFTER_OR_EQUAL_TO, LESSER_DATE);
    assertTrue(result);

    result = DateHelper.is(LESSER_DATE, DateHelper.TimeComparator.AFTER_OR_EQUAL_TO, LESSER_DATE);
    assertTrue(result);
  }

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
  public void toMilliseconds_fromDays_returnsMilliseconds() {
    long result = DateHelper.toMilliseconds(2, DAYS);
    assertEquals(2 * 24 * 60 * 60 * 1000, result);
  }

  @Test
  public void toMilliseconds_fromHours_returnsMilliseconds() {
    long result = DateHelper.toMilliseconds(2, HOURS);
    assertEquals(2 * 60 * 60 * 1000, result);
  }

  @Test
  public void toMilliseconds_fromMinutes_returnsMilliseconds() {
    long result = DateHelper.toMilliseconds(2, MINUTES);
    assertEquals(2 * 60 * 1000, result);
  }

  @Test
  public void toMilliseconds_fromSeconds_returnsMilliseconds() {
    long result = DateHelper.toMilliseconds(2, SECONDS);
    assertEquals(2 * 1000, result);
  }

  @Test
  public void toMilliseconds_fromMilliseconds_returnsMilliseconds() {
    long result = DateHelper.toMilliseconds(2, MILLISECONDS);
    assertEquals(2, result);
  }

  @Test
  public void toMilliseconds_nullUnit_returnsMilliseconds() {
    long result = DateHelper.toMilliseconds(2, null);
    assertEquals(2, result);
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
