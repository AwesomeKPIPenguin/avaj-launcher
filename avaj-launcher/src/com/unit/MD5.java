
package com.unit;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;
import java.util.Hashtable;

public class MD5 {

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
            dict.put(
                DatatypeConverter.printHexBinary(md.digest()).toUpperCase(),
                name
            );
            md.update(name.toLowerCase().getBytes());
            dict.put(
                DatatypeConverter.printHexBinary(md.digest()).toUpperCase(),
                name.toLowerCase()
            );
            md.update(name.toUpperCase().getBytes());
            dict.put(
                DatatypeConverter.printHexBinary(md.digest()).toUpperCase(),
                name.toUpperCase()
            );
        }
    }

    private static void FillNumbers(Dictionary dict) {

        // Maximum input coordinate in MD5 is limited by 10 000

        String numberString;

        for (int i = 0; i < 10000; ++i) {

            numberString = String.valueOf(i);
            md.update(numberString.getBytes());
            dict.put(
                DatatypeConverter.printHexBinary(md.digest()).toUpperCase(),
                numberString
            );
        }
    }

    public static String getValueFromMD5(String hash)
        throws UnknownValueOfMD5Exception {

        String value;

        try { value = dictionary.get(hash); } catch (Exception e) {
            throw new UnknownValueOfMD5Exception();
        }

        return value;
    }
}
