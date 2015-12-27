package br.com.formandoideias.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5 {

    public static String valueOf(String valor) {

        String sen = "";
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
        sen = hash.toString(16);

        return sen;
    }

}
