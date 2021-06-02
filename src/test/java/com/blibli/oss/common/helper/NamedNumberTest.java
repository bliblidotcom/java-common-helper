package com.blibli.oss.common.helper;

import com.blibli.oss.common.helper.config.HttpStatusCode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ardika Rommy Sanjaya
 */
public class NamedNumberTest {

    public static final int NOT_FOUND_CODE = 404;
    public static final int UNKNOWN_CODE = 10000;
    public static final int INTERNAL_SERVER_ERROR_CODE = 500;

    @Test
    public void found() {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(NOT_FOUND_CODE);
        assertEquals(HttpStatusCode.NOT_FOUND.getValue(), httpStatusCode.getValue());
    }

    @Test
    public void notFound() {
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(UNKNOWN_CODE);
        assertEquals(HttpStatusCode.UNKNOWN.getValue(), httpStatusCode.getValue());
    }

    @Test
    public void registerNewCode() {
        /**
         * Register http status code.
         */
        HttpStatusCode httpStatusCode = new HttpStatusCode(INTERNAL_SERVER_ERROR_CODE, "Internal Server Error.r");
        HttpStatusCode.register(httpStatusCode);

        /**
         * Test
         */
        HttpStatusCode internalServerError = HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR_CODE);
        assertEquals(httpStatusCode.getValue(), internalServerError.getValue());
    }

}
