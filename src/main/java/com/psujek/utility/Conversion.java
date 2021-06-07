package com.psujek.utility;

import java.nio.charset.Charset;

public class Conversion {
    private static final Charset DEFAULT_CHARSET = Charset.forName("Cp1250");

    public static String convertByteArrayToString(byte[] data) {
        return new String(data, DEFAULT_CHARSET);
    }

    public static byte[] convertStringToByteArray(String text) {
        return text.getBytes(DEFAULT_CHARSET);
    }
}
