package com.blibli.oss.common.helper;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.MILLISECONDS;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.SECONDS;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.MINUTES;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.HOURS;
import static com.blibli.oss.common.helper.DateHelper.TimeUnit.DAYS;

/**
 * @author william.s.setiadi
 */
public class DateHelper {

  enum TimeUnit {
    MILLISECONDS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS
  }

  enum TimeComparator {
    BEFORE,
    BEFORE_OR_EQUAL_TO,
    EQUAL_TO,
    NOT_EQUAL_TO,
    AFTER,
    AFTER_OR_EQUAL_TO
  }

  static class CommonDateTimePatterns {

    /**
     * Sample result: 29-01-17
     */
    public static final String dd_MM_yy = "dd-MM-yy";

    /**
     * Sample result: 29-01-2017
     */
    public static final String dd_MM_yyyy = "dd-MM-yyyy";

    /**
     * Sample result: 29-Jan-2017
     */
    public static final String dd_MMM_yyyy = "dd-MMM-yyyy";

    /**
     * Sample result: 29-Jan-2017 13:50
     */
    public static final String dd_MMM_yyyy__HH_mm = "dd-MMM-yyyy HH:mm";

    /**
     * Sample result: 29-Jan-2017 13:50:59
     */
    public static final String dd_MMM_yyyy__HH_mm_ss = "dd-MMM-yyyy HH:mm:ss";
  }

  /**
   *
   * @param date
   * @param diff
   * @param unit
   * @return
   */
  public static Date add(Date date, int diff, TimeUnit unit) {
    if (date != null) {
      return new Date(date.getTime() + toMilliseconds(diff, unit));
    }
    return null;
  }

  /**
   *
   * @param date
   * @param diff
   * @param unit
   * @return
   */
  public static Date minus(Date date, int diff, TimeUnit unit) {
    if (date != null) {
      return new Date(date.getTime() - toMilliseconds(diff, unit));
    }
    return null;
  }

  /**
   *
   * @param startDate
   * @param comparator
   * @param endDate
   * @return
   */
  public static boolean is(Date startDate, TimeComparator comparator, Date endDate) {
    if (startDate == null || endDate == null) {
      return false;
    }

    if (TimeComparator.BEFORE.equals(comparator)) {
      return startDate.before(endDate);
    } else if (TimeComparator.BEFORE_OR_EQUAL_TO.equals(comparator)) {
      return startDate.before(endDate) || startDate.equals(endDate);
    } else if (TimeComparator.EQUAL_TO.equals(comparator)) {
      return startDate.equals(endDate);
    } else if (TimeComparator.NOT_EQUAL_TO.equals(comparator)) {
      return !startDate.equals(endDate);
    } else if (TimeComparator.AFTER.equals(comparator)) {
      return startDate.after(endDate);
    } else if (TimeComparator.AFTER_OR_EQUAL_TO.equals(comparator)) {
      return startDate.after(endDate) || startDate.equals(endDate);
    } else {
      return false;
    }
  }

  /**
   * Syntax sugar. Returns new {@link Date}
   *
   * @return new {@link Date}
   */
  public static Date now() {
    return new Date();
  }

  /**
   * Returns string representation of the current time according to the given {@code pattern}
   *
   * @see DateHelper#now()
   * @see DateTimeFormat
   * @param pattern must conform to the specifications of {@link DateTimeFormat}
   * @return string representation of the current time
   */
  public static String now(String pattern) {
    return toString(now(), pattern);
  }

  /**
   * Parses the given {@code str} using {@code pattern} to an instance of {@link Date}.
   *
   * @param str to be parsed
   * @param pattern must conform to the specifications of {@link DateTimeFormat}.
   *                Common patterns can be found in {@link CommonDateTimePatterns}.
   * @return new instance of {@link Date} if neither {@code str} nor {@code pattern} is blank, null
   *         otherwise
   */
  public static Date toDate(String str, String pattern) {
    if (StringUtils.isNoneBlank(str, pattern)) {
      return DateTimeFormat.forPattern(pattern).parseDateTime(str).toDate();
    }
    return null;
  }

  /**
   * Returns string representation of the given {@code date} and formats it according to the given
   * {@code pattern}
   *
   * @param date to be converted to String
   * @param pattern must conform to the specifications of {@link DateTimeFormat}.
   *                Common patterns can be found in {@link CommonDateTimePatterns}.
   * @return string representation of the given {@code date}. Never returns null.
   */
  public static String toString(Date date, String pattern) {
    if (date != null && StringUtils.isNotBlank(pattern)) {
      return DateTimeFormat.forPattern(pattern).print(date.getTime());
    }
    return "";
  }

  public static long toMilliseconds(long input, TimeUnit unit) {
    while (unit != MILLISECONDS) {
      if (unit == SECONDS) {
        input *= 1000;
        unit = MILLISECONDS;
      } else if (unit == MINUTES) {
        input *= 60;
        unit = SECONDS;
      } else if (unit == HOURS) {
        input *= 60;
        unit = MINUTES;
      } else if (unit == DAYS) {
        input *= 24;
        unit = HOURS;
      }
    }

    return input;
  }
}
