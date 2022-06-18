package org.dmdev.natalliavasilyeva.regexp.utils;

public final class PhoneUtils {

    private PhoneUtils() {
    }

    private static final String PHONE_REGEXP = "(?:\\+?(375|80)?\\s?)?\\(?(17|29|33|44|25)\\)?\\s?(\\d{3})[-|\\s]?(\\d{2})[-|\\s]?(\\d{2})";

    public static String formatPhone(String phoneNumber) {
        return phoneNumber.replaceAll(PHONE_REGEXP, "+375 ($2) $3-$4-$5");
    }
}