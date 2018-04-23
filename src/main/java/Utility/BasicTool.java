package Utility;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BasicTool {

    public static String getMd5Info(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] btArr = input.getBytes("UTF-8");

            byte[] result = md.digest(btArr);

            BigInteger bigInt = new BigInteger(1, result);

            String hastText = bigInt.toString(16);
            while (hastText.length() < 32) {
                hastText = "0" + hastText;
            }

            return hastText;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";

    }
}
