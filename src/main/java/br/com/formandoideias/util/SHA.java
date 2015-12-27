package br.com.formandoideias.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA {

    public static String valueSHA192(String valor) {
        try {
            return valueOf("SHA-192", valor);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String valueSHA512(String valor) {
        try {
            return valueOf("SHA-512", valor);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String valueOf(String valor) {
        try {
            return valueOf(null, valor);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String valueOf(String algoritmo, String valor) throws NoSuchAlgorithmException {

        if(algoritmo == null) {
            algoritmo = "SHA-256";
        }

        MessageDigest md = MessageDigest.getInstance(algoritmo);
        BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
        return hash.toString(16);

    }
}
