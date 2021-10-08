import java.util.Random;
import java.util.Set;

import static java.lang.Math.*;

import java.util.Scanner;

public class Laba1 {

    public static void main(String[] args) {
        Set<Integer> lotsToCheck = Set.of(2, 3, 5, 6, 8, 10, 13, 16);
        int startA = 2;
        int endA = 17;
        int lenX = 19;
        float startX = -6;
        float endX = 3;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите минимально возможный пропуск между элементами массива при выводе:");
        int whiteSpace = scan.nextInt();
        scan.close();
        if (whiteSpace < 0) {
            whiteSpace = 0;
        }

        int[] a = creatArrayA(startA, endA); // пункт 1.
        float[] x = creatArrayX(startX, endX, lenX); //пункт 2.
        double[][] array = endArray(a, x, lotsToCheck); //пункт 3.
        printMatrix(array, maxLenValueEndArray(array, whiteSpace)); //пункт 4.
    }

    public static int[] creatArrayA(int startA, int endA) {
        //метод создает массив а
        int lenArray = endA - startA + 1;
        int[] array = new int[lenArray];

        for (int i = 0; i < lenArray; i++) {
            array[i] = i + startA;
        }
        return array;
    }

    public static float[] creatArrayX(float startX, float endX, int lenX) {
        //метод создает массив х
        float[] array = new float[lenX];
        for (int i = 0; i < lenX; i++) {
            array[i] = random(startX, endX);
        }
        return array;
    }

    public static float random(float startX, float endX) {
        //метод для генерации рандомного числа
        Random r = new Random();
        return (r.nextFloat() * (endX - startX) + startX);
    }

    public static double[][] endArray(int[] a, float[] x, Set<Integer> lotsToCheck) {
        // метод создания двумерного массива
        double[][] endArray = new double[a.length][x.length];

        for (int i = 0; i < endArray.length; i++) {
            for (int j = 0; j < endArray[i].length; j++) {
                if (a[i] == 17) {
                    endArray[i][j] = exp(asin(cos(x[j])));
                } else if (lotsToCheck.contains(a[i])) {
                    endArray[i][j] = cos(pow((PI) * sin(x[j]), 2));
                } else {
                    endArray[i][j] = ((pow((pow(exp(x[j]), asin((x[j] - 1.5) / 9) - 1)) / 4, 2) - 1) / 1) / 3;
                }
            }
        }
        return endArray;
    }

    public static void printMatrix(double[][] array, int maxLenIntValue) {
        //метод для вывода конечного массива
        String maxLen = Integer.toString(maxLenIntValue);

        for (double[] doubles : array) {
            for (double aDouble : doubles) {
                System.out.printf("%" + maxLen + ".4f", aDouble);
            }
            System.out.println();
        }
    }

    public static int maxLenValueEndArray(double[][] array, int whiteSpace) {
        //поиск максимальной длины элемента в массиве
        int max = 0;
        for (double[] doubles : array) {
            for (double doubles1 : doubles) {
                int len = Integer.toString((int) doubles1).length();
                if (len > max) {
                    max = len;
                }
            }
        }
        return max + 5 + whiteSpace;
        //+4 т.к. еще 4 знака после запятой
        //+1 для учета ","
    }
}
