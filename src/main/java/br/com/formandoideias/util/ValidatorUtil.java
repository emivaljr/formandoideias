package br.com.formandoideias.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {


    public static boolean validaEmail(String value) {
        String formato = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(formato);
        Matcher matcher = pattern.matcher(value.toString());
        return matcher.matches();
    }

    public static boolean validaCPF(String value) {
        return Mod11CPF.isValido(value);
    }

    public static boolean validaCNPJ(String value) {
        return Mod11CNPJ.isValido(value);
    }

}
