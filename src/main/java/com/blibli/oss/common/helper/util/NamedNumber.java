package com.blibli.oss.common.helper.util;

import java.io.Serializable;

/**
 * Common base class for dynamic named number (enum like).
 * Example:
 * <pre>
 * public final class HttpStatusCode extends NamedNumber<Integer, HttpStatusCode> {
 *
 *      public static final HttpStatusCode NOT_FOUND =
 *          new HttpStatusCode(404, "Not found.");
 *
 *      public static final HttpStatusCode OK =
 *          new HttpStatusCode(20, "Ok.");
 *
 *      public static final HttpStatusCode UNKNOWN =
 *          new HttpStatusCode(0, "Unknown Http Status Code.");
 *
 *      public HttpStatusCode(Integer value, String name) {
 *          super(value, name);
 *      }
 *
 *      private static final Map<Integer, HttpStatusCode> registry
 *          = new HashMap<>();
 *
 *      public static final HttpStatusCode register(final HttpStatusCode httpStatusCode) {
 *          registry.put(httpStatusCode.getValue(), httpStatusCode);
 *          return httpStatusCode;
 *      }
 *
 *      public static final HttpStatusCode valueOf(final int rawValue) {
 *          HttpStatusCode httpStatusCode = registry.get(rawValue);
 *          if (httpStatusCode == null) {
 *              return UNKNOWN;
 *          }
 *          return httpStatusCode;
 *      }
 *
 *      static {
 *          registry.put(NOT_FOUND.getValue(), NOT_FOUND);
 *          registry.put(OK.getValue(), OK);
 *          registry.put(UNKNOWN.getValue(), UNKNOWN);
 *      }
 *
 *  }
 *  </pre>
 * @see Enum
 * @see Number
 * @author Ardika Rommy Sanjaya
 * @since 0.0.1
 * @param <T> number.
 * @param <U> named number.
 */
public abstract class NamedNumber<T extends Number, U extends NamedNumber<T, ?>> implements Serializable {

    private static final long serialVersionUID = -7754849362562086047L;

    private final T value;
    private final String name;

    protected NamedNumber(T value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Returns the number of this {@code NamedNumber} object.
     * @return returns the number of this {@code NamedNumber} object.
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Returns the name of this {@code NamedNumber} object.
     * @return returns the name of this {@code NamedNumber} object.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (!(obj instanceof NamedNumber)) {
            return false;
        }
        return this.value.equals(this.getClass().cast(obj).getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder("[Value: ")
                .append(this.value.toString())
                .append(", Name: ")
                .append(this.name.toString())
                .append("]").toString();
    }

}
