package com.blibli.oss.common.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author william.s.setiadi
 */
public class CommonHelper {

  /**
   * Convenience method. Returns default value of {@link Boolean} if input is null.
   *
   * @param bool Boolean
   * @return false if input is null, otherwise returns input
   */
  public static boolean denullify(Boolean bool) {
    return bool == null ? false : bool;
  }

  /**
   * Returns new {@link Date} if the given {@code date} is null
   *
   * @param date to be checked
   * @return <strong>{@code date}</strong> if not null, new {@link Date} otherwise
   */
  public static Date denullify(Date date) {
    return date == null ? new Date() : date;
  }

  /**
   * Convenience method. Returns new instance of {@code clazz} if the input {@code t} is null.
   * <br> New instance is generated using {@link Class#newInstance()} and all exceptions thrown
   * are propagated.
   *
   * @see Class#newInstance()
   * @param t object
   * @param clazz new instance of this class will be generated if input {@code t} is null
   * @param <T> object type
   * @return null if {@code t} is null, otherwise returns new instance of {@code clazz}
   * @throws InstantiationException propagated exception, see {@link Class#newInstance()}
   * @throws IllegalAccessException propagated exception, see {@link Class#newInstance()}
   */
  public static <T> T denullify(T t, Class<T> clazz) throws InstantiationException,
      IllegalAccessException {
    return t == null ? clazz.newInstance() : t;
  }

  /**
   * Denullifies the given object by substituting it with the provided {@code subs}. <br>
   * @param t object
   * @param subs array of substitutes
   * @param <T> object type
   * @return the object {@code t} itself if not null, otherwise returns the first non-null
   * substitute from {@code subs}. <strong>May return null if all substitutes are null.</strong>
   */
  public static <T> T denullify(T t, T... subs) {
    if (t == null && subs != null) {
      for (T sub : subs) {
        if (sub != null) {
          t = sub;
          break;
        }
      }
    }
    return t;
  }

  /**
   * Convenience method. Returns default value of {@link Double} if input is null.
   *
   * @param num Double
   * @return 0.0 if input is null, otherwise returns input
   */
  public static Double denullify(Double num) {
    return num == null ? 0.0 : num;
  }

  /**
   * Convenience method. Returns default value of {@link Integer} if input is null.
   *
   * @param num Integer
   * @return 0 if input is null, otherwise returns input
   */
  public static Integer denullify(Integer num) {
    return num == null ? 0 : num;
  }

  /**
   * Convenience method. Denullifies {@link List}.
   * @param <T> type of the given list
   * @param list List
   * @return new {@link ArrayList} if input is null, otherwise returns input
   */
  public static <T> List<T> denullify(List<T> list) {
    return list == null ? new ArrayList<T>() : list;
  }

  /**
   * Convenience method. Returns default value of {@link Long} if input is null.
   *
   * @param num Long
   * @return 0 if input is null, otherwise returns input
   */
  public static Long denullify(Long num) {
    return num == null ? 0 : num;
  }

  /**
   * Convenience method. Returns empty map if input is null.
   *
   * @param map map
   * @return new {@link HashMap} if null, the {@code map} itself otherwise
   */
  public static <K, V> Map<K, V> denullify(Map<K, V> map) {
    return map == null ? new HashMap<>() : map;
  }

  /**
   * Convenience method. Denullifies {@link Set}.
   *
   * @param <T> type of the given set
   * @param set Set
   * @return new {@link HashSet} if input is null, otherwise returns set
   */
  public static <T> Set<T> denullify(Set<T> set) {
    return set == null ? new HashSet<T>() : set;
  }

  /**
   * Convenience method. Returns default value of {@link String} if input is null.
   *
   * @param str String
   * @return empty String if input is null, otherwise returns str
   */
  public static String denullify(String str) {
    return str == null ? "" : str;
  }

  /**
   * Shortens null object validation before doing an operation on the given object. <br>
   * Note that this does not validate null sub-objects.
   *
   * @param <T> type of object {@code t}
   * @param t object on which the given function will be invoked
   * @param consumer operation to be done on the object
   */
  public static <T> void doIfNotNull(T t, Consumer<T> consumer) {
    if (t != null) {
      consumer.accept(t);
    }
  }

  /**
   * Generates new random UUID using {@link UUID#randomUUID()}
   *
   * @return random UUID
   */
  public static String generateUUID() {
    return UUID.randomUUID().toString();
  }

  /**
   * Shortens null object validation before doing an operation on the given object
   * that returns a value.<br>
   * Note that this does not validate null sub-objects.<br>
   * Also note that the operation cannot return void. For this, use
   * {@link CommonHelper#doIfNotNull(Object, Consumer)}. <br>
   * <strong>Avoid assigning the returned value to a primitive data type as this method may return null
   * even if {@code func} returns a primitive data type.</strong>
   *
   * @param <T> type of the object {@code t}
   * @param <R> type of return value of {@code func}
   * @param t object
   * @param func operation to be done on the object
   * @return null if object is null, otherwise returns the result of the operation
   */
  public static <T, R> R getIfNotNull(T t, Function<T, R> func) {
    return t == null ? null : func.apply(t);
  }

  /**
   * Syntax sugar. Shortens null validation on a String before doing {@link String#toLowerCase()}
   *
   * @param str String
   * @return null if input is null, otherwise returns lower-cased version of the input
   */
  public static String toLowerCase(String str) {
    return str == null ? null : str.toLowerCase();
  }

  /**
   * Syntax sugar. Shortens null validation on a String before doing {@link String#toUpperCase()}
   *
   * @param str String
   * @return null if input is null, otherwise returns upper-cased version of the input
   */
  public static String toUpperCase(String str) {
    return str == null ? null : str.toUpperCase();
  }

  /**
   * Returns Enum object of the given string {@code s}. Uses {@link Enum#valueOf(Class, String)} to
   * match String and Enum object
   *
   * @param <E> type of enum
   * @param str string to be converted to Enum object
   * @param clazz class to which the Enum object belongs
   * @return null if {@code str} is blank, otherwise returns Enum object of {@code str}
   */
  public static <E extends Enum<E>> E valueOf(String str, Class<E> clazz) {
    return StringUtils.isBlank(str) ? null : Enum.valueOf(clazz, str);
  }
}
