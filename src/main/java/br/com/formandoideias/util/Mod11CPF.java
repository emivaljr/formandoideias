package br.com.formandoideias.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class Mod11CPF {

    private static final List<String> CPFS_INVALIDOS = Arrays.asList(new String[] {
        "00000000191", "00000000000", "11111111111", "22222222222",
        "33333333333", "44444444444", "55555555555", "66666666666",
        "77777777777", "88888888888", "99999999999" });

    public static boolean isValido(String cpf) {

        boolean valido;

        cpf = cpf.trim().replace("[\\.\\-]", "");
        Pattern pattern = Pattern.compile("[0-9]{11}");
        valido = pattern.matcher(cpf).matches();

        if(!valido) {
            return false;
        }

        valido = !CPFS_INVALIDOS.contains(cpf);

        if(!valido) {
            return false;
        }

        String temp = cpf.substring(0,9);
        temp += obterDV(temp);
        temp += obterDV(temp);

        return cpf.equals(temp);

    }

    public static String obterDV(String cpf) {

        int soma = 0;
        int d = 0;
        int fator = cpf.length() + 1;
        String fonte = cpf;

        for (int i = 0; i < fonte.length(); i++) {
            d = fonte.charAt(i) - '0';
            soma += d * (fator--);
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

        System.out.println(Mod11CPF.isValido("78735653191"));

        //String saida = "862972780001";
        String saida = "787356531";
        saida += Mod11CPF.obterDV(saida);
        saida += Mod11CPF.obterDV(saida);
        System.out.println(saida);

        saida = "862972780001";
        saida += Mod11CPF.obterDV(saida);
        saida += Mod11CPF.obterDV(saida);
        System.out.println(saida);

    }
}