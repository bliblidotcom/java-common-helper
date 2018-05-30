package com.blibli.oss.common.helper;

import com.blibli.oss.common.helper.constants.Comparator;

import java.math.BigDecimal;

/**
 * @author william.s.setiadi
 */
public class NumberHelper {

  public enum ParseMode {
    /**
     * Suppresses {@link NumberFormatException} that may be thrown during operation
     */
    SUPPRESS_EXCEPTION,
    /**
     * Propagates {@link NumberFormatException} that may be thrown during operation
     */
    STRICT
  }

  private static boolean compare(Comparator cmp, int result) {
    switch (cmp) {
      case LT:
        return result < 0;
      case LTE:
        return result <= 0;
      case EQ:
        return result == 0;
      case NEQ:
        return result != 0;
      case GT:
        return result > 0;
      case GTE:
        return result >= 0;
      default:
        return false;
    }
  }

  /**
   * Evaluates {@code num1} to {@code num2} according to the operand {@code cmp} <br>
   * For example:
   * <ul>
   * <li>{@code is(5, Comparator.LTE, 5)} = <strong>true</strong></li>
   * <li>{@code is(4, Comparator.LTE, 5)} = <strong>true</strong></li>
   * <li>{@code is(5, Comparator.LTE, 4)} = <strong>false</strong></li>
   * <li>{@code is(null, Comparator.EQ, null)} = <strong>true</strong></li>
   * <li>{@code is(null, Comparator.LTE, null)} = <strong>false</strong></li>
   * </ul>
   *
   * @param num1 first number
   * @param cmp of type {@link Comparator}
   * @param num2 second number
   * @return <strong>true</strong> if {@code num1} satisfies the operand {@code cmp} when evaluated
   *         to {@code num2} <br>
   *         <strong>false</strong> if either of the following is true:
   *         <ul>
   *           <li>Both {@code num1} and {@code num2} are null and {@link Comparator#EQ} is not used</li>
   *           <li>Both {@code num1} and {@code num2} are null and {@link Comparator#NEQ} is used</li>
   *           <li>Both {@code num1} and {@code num2} are not null and {@link Comparator#NEQ} is used</li>
   *           <li>Either one of {@code num1} or {@code num2} is null</li>
   *           <li>{@code num1} does not satisfy the operand {@code cmp} when evaluated to
   *           {@code num2}</li>
   *         </ul>
   */
  public static boolean is(BigDecimal num1, Comparator cmp, BigDecimal num2) {
    if (Comparator.EQ.equals(cmp) && num1 == null && num2 == null) {
      return true;
    } else if (Comparator.NEQ.equals(cmp) && (num1 == null ^ num2 == null)) {
      return true;
    } else if (num1 != null && num2 != null) {
      return compare(cmp, num1.compareTo(num2));
    }
    return false;
  }

  /**
   * see ref
   *
   * @see NumberHelper#is(BigDecimal, Comparator, BigDecimal)
   * @param num1 first number
   * @param cmp of type {@link Comparator}
   * @param num2 second number
   * @return see ref
   */
  public static boolean is(Double num1, Comparator cmp, Double num2) {
    if (Comparator.EQ.equals(cmp) && num1 == null && num2 == null) {
      return true;
    } else if (Comparator.NEQ.equals(cmp) && (num1 == null ^ num2 == null)) {
      return true;
    } else if (num1 != null && num2 != null) {
      return compare(cmp, Double.compare(num1, num2));
    }
    return false;
  }

  /**
   * see ref
   *
   * @see NumberHelper#is(BigDecimal, Comparator, BigDecimal)
   * @param num1 first number
   * @param cmp of type {@link Comparator}
   * @param num2 second number
   * @return see ref
   */
  public static boolean is(Long num1, Comparator cmp, Long num2) {
    if (Comparator.EQ.equals(cmp) && num1 == null && num2 == null) {
      return true;
    } else if (Comparator.NEQ.equals(cmp) && (num1 == null ^ num2 == null)) {
      return true;
    } else if (num1 != null && num2 != null) {
      return compare(cmp, Long.compare(num1, num2));
    }
    return false;
  }

  /**
   * Parses the given {@code str} as {@code double}
   *
   * @param str to be parsed to double
   * @param parseMode to specify whether to suppress parsing exceptions or not
   * @return parsed double. If exception occurs and parseMode is
   *         {@link ParseMode#SUPPRESS_EXCEPTION}, returns 0d
   * @throws NumberFormatException if parseMode is {@link ParseMode#STRICT}
   */
  public static double parseDouble(String str, ParseMode parseMode) {
    try {
      return Double.parseDouble(str);
    } catch (NumberFormatException e) {
      if (ParseMode.SUPPRESS_EXCEPTION.equals(parseMode)) {
        return 0d;
      } else {
        throw e;
      }
    }
  }

  /**
   * Parses the given {@code str} as int
   *
   * @param str to be parsed to int
   * @param parseMode to specify whether to suppress parsing exceptions or not
   * @return parsed int. If exception occurs and parseMode is {@link ParseMode#SUPPRESS_EXCEPTION},
   *         returns 0
   * @throws NumberFormatException if parseMode is {@link ParseMode#STRICT}
   */
  public static int parseInt(String str, ParseMode parseMode) {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      if (ParseMode.SUPPRESS_EXCEPTION.equals(parseMode)) {
        return 0;
      } else {
        throw e;
      }
    }
  }

  /**
   * Parses the given {@code str} as long
   *
   * @param str to be parsed to long
   * @param parseMode to specify whether to suppress parsing exceptions or not
   * @return parsed long. If exception occurs and parseMode is {@link ParseMode#SUPPRESS_EXCEPTION},
   *         returns 0L
   * @throws NumberFormatException if parseMode is {@link ParseMode#STRICT}
   */
  public static long parseLong(String str, ParseMode parseMode) {
    try {
      return Long.parseLong(str);
    } catch (NumberFormatException e) {
      if (ParseMode.SUPPRESS_EXCEPTION.equals(parseMode)) {
        return 0L;
      } else {
        throw e;
      }
    }
  }
}
