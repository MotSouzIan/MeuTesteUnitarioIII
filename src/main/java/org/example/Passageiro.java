package org.example;

import java.util.regex.Pattern;


public class Passageiro {
    private int id;
    private String nome;
    private String cpf;
    private String email;

    public Passageiro(int id, String nome, String cpf, String email) {
        if (!validarCPF(cpf)) throw new IllegalArgumentException("CPF inválido");
        if (!validarEmail(email)) throw new IllegalArgumentException("Email inválido");

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                d1 += digito * (10 - i);
                d2 += digito * (11 - i);
            }
            d1 = (d1 * 10) % 11;
            d1 = (d1 == 10) ? 0 : d1;
            d2 += d1 * 2;
            d2 = (d2 * 10) % 11;
            d2 = (d2 == 10) ? 0 : d2;

            return d1 == Character.getNumericValue(cpf.charAt(9)) &&
                    d2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$", email);
    }

    @Override
    public String toString() {
        return id + " - " + nome + " | CPF: " + cpf + " | Email: " + email;
    }
}
