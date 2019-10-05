
package com.unit;

import com.unit.exceptions.UnknownValueOfMD5Exception;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;
import java.util.Hashtable;

public class MD5 {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private static MessageDigest md;
    private static Dictionary<String, String> dictionary;
    private static String names[] = {

        "JetPlane",
        "Helicopter",
        "Baloon"
    };

    static {

        try { GenerateDictionary(); } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String bytesToHex(byte[] bytes) {

        char[] hexChars = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static void GenerateDictionary()
        throws NoSuchAlgorithmException  {

        md = MessageDigest.getInstance("MD5");
        dictionary = new Hashtable<>(11000);

        FillNames(dictionary);
        FillNumbers(dictionary);
    }

    private static void FillNames(Dictionary dict) {

        // Saving 3 cases of the name: Example, EXAMPLE and example

        for (String name : names) {

            md.update(name.getBytes());
            dict.put(bytesToHex(md.digest()), name);
            md.update(name.toLowerCase().getBytes());
            dict.put(bytesToHex(md.digest()), name.toLowerCase());
            md.update(name.toUpperCase().getBytes());
            dict.put(bytesToHex(md.digest()), name.toUpperCase());
        }
    }

    private static void FillNumbers(Dictionary dict) {

        // Maximum input coordinate in MD5 is limited by 10 000

        String numberString;

        for (int i = 0; i < 10000; ++i) {

            numberString = String.valueOf(i);
            md.update(numberString.getBytes());
            dict.put(bytesToHex(md.digest()), numberString);
        }
    }

    public static String getValueFromMD5(String hash)
        throws UnknownValueOfMD5Exception {

        String value;

        try { value = dictionary.get(hash); } catch (Exception e) {
            throw new UnknownValueOfMD5Exception();
        }
        if (value == null)
            throw new UnknownValueOfMD5Exception();
        return value;
    }
}
