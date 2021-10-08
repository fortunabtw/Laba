import java.util.Random;
import java.util.Set;
import static java.lang.Math.*;
import java.util.Scanner;

public class Laba1 {

    public static void main(String[] args) {
        Set<Integer> p = Set.of(2,3,5,6,8,10,13,16);
        int startA = 2;
        int endA = 17;
        int lenX = 19;
        float startX = -6;
        float endX = 3;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите минимально возможный пропуск между элементами массива при выводе:");
        int WhiteSpace = scan.nextInt();
        scan.close();
        if (WhiteSpace < 0){
            WhiteSpace = 0;
        }

        int[] a = creatArrayA(startA, endA); // пункт 1.
        float[] x = creatArrayX(startX, endX, lenX); //пункт 2.
        double[][] Array = endArray(a, x, p); //пункт 3.
        printMatrix(Array,maxLenValueEndArray(Array,WhiteSpace)); //пункт 4.
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

    public static float[] creatArrayX(float startX,float endX,int lenX){
        //метод создает массив х
        float[] array = new float[lenX];
        for (int i = 0; i < lenX ; i++) {
            array[i] = random(startX,endX);
        }
        return array;
    }

    public static float random(float startX,float endX) {
        //метод для генерации рандомного числа
        Random r = new Random();
        return (r.nextFloat()*(endX-startX) + startX);
    }

    public static double[][] endArray(int[] a, float[] x, Set<Integer> p) {
        // метод создания двумерного массива
        double[][] ae = new double[a.length][x.length];

        for (int i = 0; i < ae.length; i++) {
            for (int j = 0; j < ae[i].length; j++) {
                if (a[i] == 17) {
                    ae[i][j] = exp(asin(cos(x[j])));
                } else if (p.contains(a[i])) {
                    ae[i][j] = cos(pow((PI) * sin(x[j]), 2));
                } else {
                    ae[i][j] = ((pow((pow(exp(x[j]), asin((x[j] - 1.5) / 9) - 1)) / 4, 2) - 1) / 1) / 3;
                }
            }
        }
        return ae;
    }

    public static void printMatrix(double[][] Array,int MaxLenIntValue){
        //метод для вывода конечного массива
        String MaxLen = Integer.toString(MaxLenIntValue);

        for (double[] doubles : Array) {
            for (double aDouble : doubles) {
                System.out.printf("%"+MaxLen+".4f", aDouble);
            }
            System.out.println();
        }
    }

    public static int maxLenValueEndArray(double[][] Array,int o) {
        //поиск максимальной длины элемента в массиве
        int max = 0;
        for (double[] doubles : Array){
            for (double doubles1 : doubles){
                int len = Integer.toString((int) doubles1).length();
                if (len > max){
                    max = len;
                }
            }
        }
        return max + 5 + o;
        //+4 т.к. еще 4 знака после запятой
        //+1 для учета ","
    }
}
