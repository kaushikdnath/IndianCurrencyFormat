package Rupee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kaushik Deb Nath
 */
public class CurrencyFormat {

    //reverse order ###,##,##,########
    private static char[] COMMAS = new char[]{'#', '#', '#', ',', '#', '#', ',', '#', '#', ',', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};

    public static String format(Integer value) {
        if (value == null) {
            return "";
        } else {
            return format(new Long(value));
        }
    }

    public static String format(Integer value, Integer decimalPlaces) {

        if (value == null) {
            return "";
        } else {
            return format(new Long(value));
        }
    }

    public static String format(Short value) {

        if (value == null) {
            return "";
        } else {
            return format(new Long(value));
        }
    }

    public static String format(Short value, Integer decimalPlaces) {

        if (value == null) {
            return "";
        } else {
            return format(new Long(value));
        }
    }

    public static String format(Long value) {

        if (value == null) {
            return "";
        } else {
            String currency = String.format("%d", value);
            return format(currency);
        }
    }

    public static String format(Long value, Integer decimalPlaces) {

        if (value == null) {
            return "";
        } else {
            return format(value);
        }
    }

    public static String format(Float value) {

        if (value == null) {
            return "";
        } else {
            String currency = String.format("%.2f", value);
            return format(currency);
        }
    }

    public static String format(Float value, Integer decimalPlaces) {

        if (value == null) {
            return "";
        } else {
            String currency = String.format("%." + decimalPlaces + "f", value);
            return format(currency, decimalPlaces);
        }
    }

    public static String format(Double value) {

        if (value == null) {
            return "";
        } else {
            String currency = String.format("%.2f", value);
            return format(currency);
        }
    }

    public static String format(Double value, Integer decimalPlaces) {

        if (value == null) {
            return "";
        } else {
            String currency = String.format("%." + decimalPlaces + "f", value);
            return format(currency, decimalPlaces);
        }
    }

    public static String format(String value) {
        if (value == null) {
            return "";
        } else {
            String minusSymbol=(value.contains("-"))?"-":"";
            value=value.replaceFirst("-", "");
            String currency = String.format("%s", value);
            Matcher m = (Pattern.compile("\\.\\d*")).matcher(currency);
            String decimal = "";
            if (m.find()) {
                decimal = m.group(0);                       //Extract decimal point and digits after that
                currency = currency.replaceAll("\\" + decimal, "");//Remove extracted from currency
            }
            String indiancurrency = "";
            for (int i = currency.length() - 1, c = 0; i >= 0; i--, c++) {
                if (COMMAS[c] == ',') {
                    c++;
                    indiancurrency = currency.charAt(i) + "," + indiancurrency;
                } else {
                    indiancurrency = currency.charAt(i) + indiancurrency;
                }
            }
//        return ((indiancurrency.trim().charAt(0) == ',') ? indiancurrency.trim().substring(1) : indiancurrency.trim()) + decimal;
            return minusSymbol+indiancurrency.trim() + decimal;
        }
    }

    public static String format(String value, Integer decimalPlaces) {
        if (value == null) {
            return "";
        } else {
            String minusSymbol=(value.contains("-"))?"-":"";
            value=value.replaceFirst("-", "");
            String currency = String.format("%s", value);
            Matcher m = (Pattern.compile("\\.\\d*")).matcher(currency);
            String decimal = "";
            if (m.find()) {
                decimal = (m.group(0).length() > decimalPlaces) ? m.group(0).substring(0, decimalPlaces + 1) : m.group(0);                       //Extract decimal point and digits after that
                currency = currency.replaceAll("\\" + decimal, "");//Remove extracted from currency
            }
            String indiancurrency = "";
            for (int i = currency.length() - 1, c = 0; i >= 0; i--, c++) {
                if (COMMAS[c] == ',') {
                    c++;
                    indiancurrency = currency.charAt(i) + "," + indiancurrency;
                } else {
                    indiancurrency = currency.charAt(i) + indiancurrency;
                }
            }
            return minusSymbol+indiancurrency.trim() + decimal;
        }
    }
}
