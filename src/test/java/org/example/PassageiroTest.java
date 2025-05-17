package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassageiroTest {

    @Test
    void testCPFValido() {
        assertTrue(Passageiro.validarCPF("111.444.777-35"));
    }

    @Test
    void testCPFInvalido() {
        assertFalse(Passageiro.validarCPF("123.456.789-00"));
    }

    @Test
    void testEmailValido() {
        assertTrue(Passageiro.validarEmail("teste@exemplo.com"));
    }

    @Test
    void testEmailInvalido() {
        assertFalse(Passageiro.validarEmail("teste@@exemplo"));
    }

    @Test
    void testCadastroPassageiro() {
        Passageiro p = new Passageiro(1, "João", "111.444.777-35", "joao@teste.com");
        assertEquals("João", p.toString().split(" - ")[1].split(" \\|")[0]);
    }
}