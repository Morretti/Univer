package TA.Coursework;


import static TA.Coursework.Strassen.*;

public class Main {
    public static void main(String[] args){
        int[][] first = new int[10][5];
        int[][] second = new int[5][7];

        for (int i = 0; i < first.length; i++){
            for (int j = 0; j < first[i].length; j++){
                first[i][j] = (int)(Math.random()*51);
            }
        }

        for (int i = 0; i < second.length; i++){
            for (int j = 0; j < second[i].length; j++){
                second[i][j] = (int)(Math.random()*51);
            }
        }

        int[][] result = multiplyStrassen(first,second);

        for (int i = 0; i < first.length; i++){
            for (int j = 0; j < second[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
