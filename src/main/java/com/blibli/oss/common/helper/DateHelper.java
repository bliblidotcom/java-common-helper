package com.blibli.oss.common.helper;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import com.blibli.oss.common.helper.constants.CommonDateTimePatterns;
import com.blibli.oss.common.helper.constants.TimeUnit;
import com.blibli.oss.common.helper.constants.TimeComparator;

import java.util.Date;
import static com.blibli.oss.common.helper.constants.TimeUnit.MILLISECONDS;
import static com.blibli.oss.common.helper.constants.TimeUnit.SECONDS;
import static com.blibli.oss.common.helper.constants.TimeUnit.MINUTES;
import static com.blibli.oss.common.helper.constants.TimeUnit.HOURS;
import static com.blibli.oss.common.helper.constants.TimeUnit.DAYS;

/**
 * @author william.s.setiadi
 */
public class DateHelper {

  /**
   * Adds the specified amount of time to the given {@code date}.
   *
   * @param date to be added
   * @param diff amount of difference, to be paired with {@code unit}
   * @param unit of type {@link TimeUnit}
   * @return new instance of {@link Date} with the added amount of time difference if the base
   * {@code date} is not null, otherwise returns null
   */
  public static Date add(Date date, int diff, TimeUnit unit) {
    if (date != null) {
      return new Date(date.getTime() + toMilliseconds(diff, unit));
    }
    return null;
  }

  /**
   * Subtracts the specified amount of time from the given {@code date}.
   *
   * @param date to be subtracted
   * @param diff amount of difference, to be paired with {@code unit}
   * @param unit of type {@link TimeUnit}
   * @return new instance of {@link Date} with the subtracted amount of time difference if the base
   * {@code date} is not null, otherwise returns null
   */
  public static Date minus(Date date, int diff, TimeUnit unit) {
    if (date != null) {
      return new Date(date.getTime() - toMilliseconds(diff, unit));
    }
    return null;
  }

  /**
   * Evaluates whether {@code firstDate} satisfies {@code comparator} when compared to {@code secondDate}.
   *
   * @param firstDate of type {@link Date}
   * @param comparator of type {@link TimeComparator}
   * @param secondDate of type {@link Date}
   * @return true if {@code firstDate} satisfies {@code comparator} when compared to {@code secondDate}.
   * <br>Returns false if one of the following is true:
   * <ul>
   *   <li>Both {@code firstDate} and {@code secondDate} are null and {@link TimeComparator#EQUAL_TO} is not used</li>
   *   <li>Both {@code firstDate} and {@code secondDate} are null and {@link TimeComparator#NOT_EQUAL_TO} is used</li>
   *   <li>Both {@code firstDate} and {@code secondDate} are not null and {@link TimeComparator#NOT_EQUAL_TO} is used</li>
   *   <li>Either one of {@code firstDate} or {@code secondDate} is null</li>
   *   <li>{@code comparator} is null</li>
   *   <li>{@code firstDate} does not satisfy {@code comparator} when compared to {@code secondDate} </li>
   * </ul>
   */
  public static boolean is(Date firstDate, TimeComparator comparator, Date secondDate) {
    if (TimeComparator.EQUAL_TO.equals(comparator) && firstDate == null && secondDate == null) {
      return true;
    } else if (TimeComparator.NOT_EQUAL_TO.equals(comparator) && (firstDate == null ^ secondDate == null)) {
      return true;
    } else if (firstDate == null || secondDate == null) {
      return false;
    }

    if (TimeComparator.BEFORE.equals(comparator)) {
      return firstDate.before(secondDate);
    } else if (TimeComparator.BEFORE_OR_EQUAL_TO.equals(comparator)) {
      return firstDate.before(secondDate) || firstDate.equals(secondDate);
    } else if (TimeComparator.EQUAL_TO.equals(comparator)) {
      return firstDate.equals(secondDate);
    } else if (TimeComparator.NOT_EQUAL_TO.equals(comparator)) {
      return !firstDate.equals(secondDate);
    } else if (TimeComparator.AFTER.equals(comparator)) {
      return firstDate.after(secondDate);
    } else if (TimeComparator.AFTER_OR_EQUAL_TO.equals(comparator)) {
      return firstDate.after(secondDate) || firstDate.equals(secondDate);
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

  /**
   * Converts {@code input} to milliseconds with respect to the given {@code unit}
   *
   * @param input time, paired with {@code unit}
   * @param unit  of type {@link TimeUnit}. <strong>Passing null will return the input itself, without converting it into milliseconds</strong>
   * @return milliseconds value of {@code input}.
   */
  public static long toMilliseconds(long input, TimeUnit unit) {
    long result = input;

    if (unit != null) {
      while (unit != MILLISECONDS) {
        if (unit == SECONDS) {
          result *= 1000;
          unit = MILLISECONDS;
        } else if (unit == MINUTES) {
          result *= 60;
          unit = SECONDS;
        } else if (unit == HOURS) {
          result *= 60;
          unit = MINUTES;
        } else if (unit == DAYS) {
          result *= 24;
          unit = HOURS;
        }
      }
    }

    return result;
  }
}
