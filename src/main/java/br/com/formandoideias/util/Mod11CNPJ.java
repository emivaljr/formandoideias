package br.com.formandoideias.util;

import java.util.regex.Pattern;

public final class Mod11CNPJ {

    public static boolean isValido(String cnpj) {

        boolean valido;

        cnpj = cnpj.trim().replace("[\\.\\-\\/]", "");
        Pattern pattern = Pattern.compile("[0-9]{14}");
        valido = pattern.matcher(cnpj).matches();

        if(!valido) {
            return false;
        }

        String temp = cnpj.substring(0,12);
        temp += obterDV(temp);
        temp += obterDV(temp);

        return cnpj.equals(temp);

    }

    public static String obterDV(String cnpj) {

        int soma = 0;
        int d = 0;
        int fator = cnpj.length() - 7;
        String fonte = cnpj;

        for (int i = 0; i < fonte.length(); i++) {
            d = fonte.charAt(i) - '0';
            soma += d * (fator--);

            if(fator == 1) {
                fator = 9;
            }
        }

        d = soma % 11;
        if (d < 2) {
            d = 0;
        } else {
            d = 11 - d;
        }

        return Integer.toString(d);

    }

    public static void main(String[] args) {

        System.out.println(Mod11CNPJ.isValido("11444777000161"));

        String saida = "114447770001";
        saida += Mod11CNPJ.obterDV(saida);
        saida += Mod11CNPJ.obterDV(saida);
        System.out.println(saida);

    }
}