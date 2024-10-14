package org.example;

import java.util.ArrayList;
import java.util.List;

public class CU {
    private String nameCU;
    private List<Mark> marks;
    private int totalStudents;

    public CU(String nameCU, int totalStudents) {
        this.nameCU = nameCU;
        this.totalStudents = totalStudents;
        this.marks = new ArrayList<>();
    }

    /**
     * Insere ou atualiza a nota de um estudante na UC
     * Se o estudante já existir, a nota é atualizada
     * Se não, uma nova entrada é criada, desde que não tenha atingido o limite de estudantes
     */
    public void insertMarkCU(int numStudent, double mark) {
        for (Mark m : marks) {
            if (m.getNumStudent() == numStudent) {
                m.setMark(mark);  // Atualiza a nota se o aluno já existir
                return;
            }
        }

        if (marks.size() < totalStudents) {
            marks.add(new Mark(numStudent, mark));
        } else {
            System.out.println("Não é possível adicionar mais alunos.");
        }
    }

    /**
     * Pesquisa e retorna a nota de um estudante, caso exista
     */
    public double searchStudent(int numStudent) {
        for (Mark m : marks) {
            if (m.getNumStudent() == numStudent) {
                return m.getMark();
            }
        }
        return -1;  // -1 se aluno não existe
    }

    /**
     * Calcula a nota média da UC
     */
    public double averageCU() {
        if (marks.isEmpty()) return 0.0;

        double total = 0;
        for (Mark m : marks) {
            total += m.getMark();
        }
        return total / marks.size();
    }

    /**
     * Verifica se um estudante teve aprovação na UC
     */
    public boolean isApproved(int numStudent) {
        double mark = searchStudent(numStudent);
        return mark >= 9.5;
    }
}