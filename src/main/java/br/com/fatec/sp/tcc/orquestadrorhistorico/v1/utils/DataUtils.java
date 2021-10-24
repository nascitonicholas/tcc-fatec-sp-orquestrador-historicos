package br.com.fatec.sp.tcc.orquestadrorhistorico.v1.utils;

import java.time.LocalDate;

public class DataUtils {

    public static String buscaAnoMesDoSemestreAtual() {
        int ano = LocalDate.now().getYear();
        int mes = LocalDate.now().getMonthValue();
        if (isPrimeiroSemestre(mes)) {
            return String.format("%s/%s", ano, "06");
        }
        return String.format("%s/%s", ano, "12");
    }

    public static boolean isPrimeiroSemestre(int mes) {
        int[] mesesPrimeiroSemestre = {1, 2, 3, 4, 5, 6};
        for (int meses: mesesPrimeiroSemestre) {
            if (mes == meses) {
                return true;
            }
        }
        return false;
    }

}
