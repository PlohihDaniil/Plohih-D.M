package matrix;


import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static void main(String[] args){

        double [][] OneMatrix = {{0.97,0.02,0.01,0},{0.02,0.98,0,0},{0,0.02,0.01,0.99},{0,0,0.01,0.99}};
        double [][] TwoMatrix = new double[4][4];
        int n = 500;

        double [] massS = {0.37,0.3,0.23,0.1};

        double [] massPb;


        System.out.println("--- Заполенение первоначальеной матрицы ---");
        for (int i =0; i<4; i++){
            for (int j=0; j<4;j++){
                System.out.print(OneMatrix[i][j] + "\t");
            }
            System.out.println();
        }



        System.out.println("--- Заполнение вероятностей появления символов ---");
        for (int i =0; i<4; i++){

            System.out.println(massS [i]);

        }

        System.out.println("--- Заполнение второй матрицы ---");

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                TwoMatrix[i][j] = OneMatrix[i][j] * massS[i];
            }
        }

        System.out.println("--- Завершено ---");
        for (int i =0; i<4; i++){
            for (int j=0; j<4;j++){
                System.out.print(TwoMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("--- Ответы ---");

        System.out.println("H(B|A)= " + HBA(OneMatrix, massS));

        massPb=pB(OneMatrix, massS);

        System.out.println("p(b) = " + Arrays.toString(massPb));

        double HB=0;

        for (double d:
             massPb) {
            HB += d * (  Math.log(d) / Math.log(2) );
        }

        HB = -1*HB;

        System.out.println("H(B)= " + HB);

        double Hab =HAB(TwoMatrix);

        System.out.println("H(A,B)= " + Hab);

        double HAB = Hab - HB;
        System.out.println("H(A|B)= " + HAB);

        double DI = HAB * n;
        System.out.println("delta I=" + DI);

        double I = n*HB-DI;
        System.out.println("I= "+ I);

    }

    public static double[] pB(double[][] matrix, double[] massS){
        double [] mass = new double[4];
        double f;

        for (int j =0;j<4;j++){
            f=0;
            for (int i=0; i<4;i++){
                f+=matrix[i][j]*massS[i];
            }
            mass[j]=f;
        }
        return mass;
    }
    public static double HAB(double[][] matrix){
        double f=0,g;

        for (int i =0;i<4;i++){
            g=0;
            for (int j=0; j<4;j++){
                g+=IfLog(matrix[i][j]);
            }
            f+=g;
        }
        return -1*f;
    }

    public static double HBA(double[][] matrix, double[] mass){
        double f=0,g;

        for (int i =0;i<4;i++){
            g=0;
            for (int j=0; j<4;j++){
                g+= IfLog(matrix[i][j]);
            }
            f+= mass[i]*g;
        }
        return -1*f;
    }
    public static double IfLog(double s){
        if (s == 0){
            return 0;
        }
        else {
           return s * (Math.log(s) / Math.log(2));
        }
    }




}
