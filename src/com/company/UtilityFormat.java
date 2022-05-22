package com.company;

import java.util.Locale;

public class UtilityFormat {
    public static String format_number(double number) {
        Locale locale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        String result = String.format("%6.2f", number);
        Locale.setDefault(locale);
        return result;
    }
}