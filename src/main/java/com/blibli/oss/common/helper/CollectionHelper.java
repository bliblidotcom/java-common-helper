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

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author william.s.setiadi on 2/19/2018.
 */
public class CollectionHelper {

  /**
   * Denullifies the given {@code list} and adds {@code elems} to it. <br>
   * Will not add null elements into the list.
   *
   * @see CommonHelper#denullify(List)
   * @param list to add elements to
   * @param elems elements to be added to the list. Null elements will not be added into the list
   * @param <T> type of the list
   * @param <V> type of the elements. Must be a subclass of &lt;T&gt;
   * @return list appended with the specified non-null elements
   */
  public static <T, V extends T> List<T> addToList(List<T> list, V... elems) {
    if (elems != null) {
      list = CommonHelper.denullify(list);

      for (T t : elems) {
        if (t != null) {
          list.add(t);
        }
      }
    }
    return list;
  }

  /**
   * Finds the first element in the collection that satisfies the predicate {@code func}.
   *
   * @param <T> type of collection's content
   * @param coll collection to be iterated
   * @param func a boolean function to evaluate the elements in {@code coll}
   * @return the first matching element. Returns null if coll is empty or no matching element is found
   */
  public static <T> T findInCollection(Collection<T> coll, Predicate<T> func) {
    if (isNotEmpty(coll)) {
      return coll.stream().filter(func).findFirst().orElse(null);
    }
    return null;
  }

  /**
   * Executes function {@code func} on the given collection {@code coll}. <br>
   * Performs null check on both the function and the collection.
   *
   * @param coll subclass of {@link Iterable} on which the function {@code func} will be performed
   * @param func function to be performed on each element of the collection {@code coll}
   * @param <T> both the collection and function must be of the same type
   */
  public static <T> void forEach(Iterable<T> coll, Consumer<T> func) {
    if (coll != null && func != null) {
      coll.forEach(func);
    }
  }

  /**
   * Checks if {@code coll} is either null or empty.
   *
   * @param coll collection to be checked, may be any subclass or implementation of {@link Collection}
   * @return true if {@code coll} is empty or null, false otherwise
   */
  public static boolean isEmpty(Collection<?> coll) {
    return coll == null || coll.isEmpty();
  }

  /**
   * Checks if {@code map} is either null or empty.
   *
   * @param map map to be checked, may be any subclass or implementation of {@link Map}
   * @return true if {@code map} is empty or null, false otherwise
   */
  public static boolean isEmpty(Map<?, ?> map) {
    return map == null || map.isEmpty();
  }

  /**
   * Checks whether {@code ele} is in the given {@code coll}. Comparison is done by invoking
   * {@link Collection#contains(Object)}.
   * <br><strong>Be careful of incorrect <code>equals()</code> implementation (e.g. not calling <code>super.equals()</code>)
   * as this may lead to incorrect result.</strong>
   *
   * @param <T> type of element
   * @param ele to be evaluated against
   * @param coll to be iterated over
   * @return <strong>true</strong> if element is found in the collection. <br>
   *         <strong>false</strong> if one of the following is true:
   *         <ul>
   *         <li>element is null</li>
   *         <li>collection is empty or null</li>
   *         <li>element is not found in the collection</li>
   *         </ul>
   */
  public static <T> boolean isInCollection(T ele, Collection<T> coll) {
    if (ele != null && isNotEmpty(coll)) {
      return coll.contains(ele);
    }
    return false;
  }

  /**
   * Checks if the enum {@code e} is in the given array of {@code enums}. Comparison is done by
   * invoking {@code e.equals()}.
   *
   * @param <E> type of enum
   * @param e to be checked
   * @param enums to be iterated over
   * @return true if {@code e} is found in {@code enums}. <br>
   *         false if one of the following is true:
   *         <ul>
   *         <li>{@code e} is null</li>
   *         <li>{@code enums} is null</li>
   *         <li>{@code e} is not found in {@code enums}</li>
   *         </ul>
   */
  public static <E extends Enum<E>> boolean isInEnumSet(E e, E... enums) {
    if (e != null && enums != null) {
      return Stream.of(enums).anyMatch(en -> en.equals(e));
    }
    return false;
  }

  /**
   * Negation of {@link CollectionHelper#isEmpty(Collection)}.
   *
   * @param coll to be checked
   * @return true if {@code coll} is neither null nor empty, false otherwise
   */
  public static boolean isNotEmpty(Collection<?> coll) {
    return !isEmpty(coll);
  }

  /**
   * Negation of {@link CollectionHelper#isEmpty(Map)}.
   *
   * @param map to be checked
   * @return true if {@code map} is neither null nor empty, false otherwise
   */
  public static boolean isNotEmpty(Map<?, ?> map) {
    return !isEmpty(map);
  }

  /**
   * Removes null elements from the collection.
   *
   * @see Collection#removeIf(java.util.function.Predicate)
   * @throws UnsupportedOperationException if the collection is immutable or fixed-size
   * @param coll to be sanitized
   */
  public static void sanitize(Collection<?> coll) {
    if (isNotEmpty(coll)) {
      coll.removeIf(Objects::isNull);
    }
  }

  /**
   * Removes elements with either null key or null value from the map.
   *
   * @see Collection#removeIf(java.util.function.Predicate)
   * @throws UnsupportedOperationException if the map is immutable or fixed-size
   * @param map to be sanitized
   */
  public static void sanitize(Map<?, ?> map) {
    if (isNotEmpty(map)) {
      map.entrySet().removeIf(entry -> Objects.isNull(entry.getKey()) || Objects.isNull(entry.getValue()));
    }
  }

  /**
   * Returns the size of the given collection.
   *
   * @see CollectionHelper#isEmpty(Collection)
   * @param coll any subclass or implementation of {@link Collection}
   * @return 0 if the collection is empty, otherwise returns the collection's size
   */
  public static int sizeOf(Collection<?> coll) {
    return isEmpty(coll) ? 0 : coll.size();
  }

  /**
   * Converts the given array of elements of type T to a new instance of
   * {@link HashSet} of the same type. Only adds non-null elements into the set.
   *
   * @param <T> type of elements which will be converted to {@link HashSet}
   * @param elems to be converted into a {@link HashSet}
   * @return new {@link HashSet} of type T. Set will be populated by non-null members of {@code elems}.
   *         Never returns null.
   */
  public static <T> Set<T> toSet(T... elems) {
    return elems == null ? new HashSet<>() : Stream.of(elems).filter(Objects::nonNull).collect(
        Collectors.toSet());
  }

  /**
   * Converts the given array of elements of type T to a new instance of
   * {@link ArrayList} of the same type. Only adds non-null elements into the list.
   *
   * @see Collectors#toList()
   * @param <T> type of elements which will be converted to {@link List}
   * @param elems to be converted into a {@link List}
   * @return new {@link ArrayList} of type T. List will be populated by non-null members of {@code elems}.
   *         Never returns null.
   */
  public static <T> List<T> toList(T... elems) {
    return elems == null ? new ArrayList<>() : Stream.of(elems).filter(Objects::nonNull).collect(Collectors.toList());
  }
}
