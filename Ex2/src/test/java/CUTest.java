package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CUTest {

    private CU uc;

    /**
     * Configura a UC para os testes, inserindo alguns estudantes e suas notas.
     */
    @BeforeEach
    public void setUp() {
        uc = new CU("Matemática", 3);
        uc.insertMarkCU(1, 8.0);
        uc.insertMarkCU(2, 12.5);
        uc.insertMarkCU(3, 9.5);
    }

    /**
     * Testa se é possível inserir novas notas e limita o número de estudantes
     */
    @Test
    public void testInsertMarkCU() {
        uc.insertMarkCU(4, 10.0);  // Não deve adicionar pois o limite é 3 alunos
        assertEquals(-1, uc.searchStudent(4));
    }

    /**
     * Testa a pesquisa de notas de estudantes
     */
    @Test
    public void testSearchStudent() {
        assertEquals(12.5, uc.searchStudent(2));
        assertEquals(-1, uc.searchStudent(5));  // Aluno inexistente
    }

    /**
     * Testa o cálculo da média das notas dos estudantes
     */
    @Test
    public void testAverageCU() {
        assertEquals(10.0, uc.averageCU());
    }

    /**
     * Testa a verificação de aprovação de estudantes usando dados paramétricos
     */
    @ParameterizedTest
    @CsvSource({
            "1, false",   // Aluno 1 tem nota 8.0, não aprovado
            "2, true",    // Aluno 2 tem nota 12.5, aprovado
            "3, true",    // Aluno 3 tem nota 9.5, aprovado
            "5, false"    // Aluno inexistente
    })
    public void testIsApproved(int numStudent, boolean expectedApproval) {
        assertEquals(expectedApproval, uc.isApproved(numStudent));
    }
}