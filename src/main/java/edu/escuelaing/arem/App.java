package edu.escuelaing.arem;

import java.util.List;

/**
 *
 * @author Sebastian Goenaga
 */
public class App {

    private static int max, min, sumatoria, multiplicatoria;
    private static String numbersList;

    public static void calculate(String numbers) throws NumberFormatException {
        String[] setNumbers = numbers.split(" ");
        max = Integer.parseInt(setNumbers[0]);
        min = Integer.parseInt(setNumbers[0]);
        sumatoria = 0;
        multiplicatoria = 1;
        numbersList = " \"Lista de numeros\" : \" ";
        for (String n : setNumbers) {
            int number = Integer.parseInt(n);
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            sumatoria += number;
            multiplicatoria *= number;
            numbersList = numbersList + n + " ";
        }
        numbersList = numbersList + "\" ";
    }

    public static int getMax() {
        return max;
    }

    public static int getMin() {
        return min;
    }

    public static int getSumatoria() {
        return sumatoria;
    }

    public static int getMultiplicatoria() {
        return multiplicatoria;
    }

    public static String getNumbersList() {
        return numbersList;
    }

}