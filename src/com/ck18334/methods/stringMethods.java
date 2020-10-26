package com.ck18334.methods;

import java.util.Collection;

public class stringMethods {
    //Print multiples of variables inside brackets.
    public static String encapsulatedTuple(String beginChar, String endChar, String limit, Object ... str) {
        String tuple;
        try {
            tuple = beginChar + determineObjectPrintout(str[0], limit, true);
        }
        catch (IndexOutOfBoundsException e) {
            tuple = beginChar;
        }
        for (int i = 1; i < str.length; i += 1) {
            if (str[i] != null) {
                tuple += determineObjectPrintout(str[i], limit, false);
            } else {
                tuple += limit + str[i];
            }
        }
        tuple += endChar;
        return tuple;
    }
    public static String encapsulatedTuple(String beginChar, String endChar, String limit, Collection str) {
        return encapsulatedTuple(beginChar, endChar, limit, str.toArray());
    }
    public static String determineObjectPrintout(Object obj, String limit, boolean start) {
        String startLimit = limit;
        if (start) {
            startLimit = "";
        }
        if (obj != null) {
            if (obj instanceof String) {
                return startLimit + "\"" + obj + "\"";
            } else if (obj instanceof Collection) {
                return startLimit + encapsulatedTuple("<", ">", limit, (Collection) obj);
            } else if (obj.getClass().isArray()) {
                return obj.toString();
            } else {
                return startLimit + obj;
            }
        }
        return startLimit + null;
    }
    public static String limitedTuple(String limit, Object ... str) {
        return encapsulatedTuple("", "", limit, str);
    }
    public static String tuple(Object ... str) {
        return encapsulatedTuple("(", ")", ", ", str);
    }

    public static void silentPrintLine(Object str, boolean silent) {
        if (!silent) {
            if (str == null) {
                System.out.println();
            }
            else {
                System.out.println(str);
            }
        }
    }
    public static void silentPrintLine(boolean silent) {
        silentPrintLine(null, silent);
    }
    public static void silentPrint(Object str, boolean silent) {
        if (!silent) {
            System.out.print(str);
        }
    }
    public static String indent(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j += 1) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
