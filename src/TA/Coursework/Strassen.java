package TA.Coursework;

public class Strassen {

    public static boolean isSquare(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length)
                return false;
        }
        return true;
    }

    public static boolean isTwoDegree(int[][] array) {
        int length = array.length;

        while (length > 1) {
            if (length % 2 == 0) {
                if ((length /= 2) == 0)
                    continue;
            } else return false;
        }
        return true;
    }

    private static void divideMatrix(int[][] matrix, int[][] c11, int[][] c12, int[][] c21, int[][] c22){
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                c11[i][j] = matrix[i][j];
                c12[i][j] = matrix[i][j + (int) (matrix.length / 2)];
                c21[i][j] = matrix[i + (int) (matrix.length / 2)][j];
                c22[i][j] = matrix[i + (int) (matrix.length / 2)][j + (int) (matrix.length / 2)];
            }
        }
    }

    private static int[][] toOneMatrix(int[][] c11, int[][] c12, int[][] c21, int[][] c22) {
        int[][] result = new int[c11.length * 2][c11.length * 2];

        for (int i = 0; i < result.length / 2; i++) {
            for (int j = 0; j < result[i].length / 2; j++) {
                result[i][j] = c11[i][j];
                result[i][j + (int) (result.length / 2)] = c12[i][j];
                result[i + (int) (result.length / 2)][j] = c21[i][j];
                result[i + (int) (result.length / 2)][j + (int) (result.length / 2)] = c22[i][j];
            }
        }

        return result;
    }

    private static int[][] adding(int[][] first, int[][] second) {
        int[][] result = new int[first.length][first.length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }

        return result;
    }

    private static int[][] subtraction(int[][] first, int[][] second) {
        int[][] result = new int[first.length][first.length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] - second[i][j];
            }
        }

        return result;
    }

    private static int[][] multiply(int[][] first, int[][] second) {
        int[][] result = new int[first.length][second.length];
        int sum = 0;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                for (int k = 0; k < second[i].length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] multiplyStrassen(int[][] first, int[][] second) {
        if (!isTwoDegree(first)) {
            first = makeTwoDegreeSize(first, second);
        }

        if (!isTwoDegree(second)) {
            second = makeTwoDegreeSize(second, first);
        }

        int[][] result = new int[first.length][first.length];

        int[][] a11 = new int[first.length / 2][first.length / 2];
        int[][] a12 = new int[first.length / 2][first.length / 2];
        int[][] a21 = new int[first.length / 2][first.length / 2];
        int[][] a22 = new int[first.length / 2][first.length / 2];

        int[][] b11 = new int[second.length / 2][second.length / 2];
        int[][] b12 = new int[second.length / 2][second.length / 2];
        int[][] b21 = new int[second.length / 2][second.length / 2];
        int[][] b22 = new int[second.length / 2][second.length / 2];

        int[][] c11 = new int[result.length / 2][result.length / 2];
        int[][] c12 = new int[result.length / 2][result.length / 2];
        int[][] c21 = new int[result.length / 2][result.length / 2];
        int[][] c22 = new int[result.length / 2][result.length / 2];

        divideMatrix(first,a11,a12,a21,a22);
        divideMatrix(second,b11,b12,b21,b22);
        divideMatrix(result,c11,c12,c21,c22);

        int[][] p1;
        int[][] p2;
        int[][] p3;
        int[][] p4;
        int[][] p5;
        int[][] p6;
        int[][] p7;

        p1 = multiply(adding(a11, a22), adding(b11, b22));
        p2 = multiply(adding(a21, a22), b11);
        p3 = multiply(a11, subtraction(b12, b22));
        p4 = multiply(a22, subtraction(b21, b11));
        p5 = multiply(adding(a11, a12), b22);
        p6 = multiply(subtraction(a21, a11), adding(b11, b12));
        p7 = multiply(subtraction(a12, a22), adding(b21, b22));

        c11 = adding(adding(p1, subtraction(p4, p5)), p7);
        c12 = adding(p3, p5);
        c21 = adding(p2, p4);
        c22 = adding(adding(subtraction(p1, p2), p3), p6);

        return result = toOneMatrix(c11, c12, c21, c22);
    }

    private static boolean isTwoDegree(int number) {
        int length = number;

        while (length > 1) {
            if (length % 2 == 0) {
                if ((length /= 2) == 0)
                    continue;
            } else return false;
        }
        return true;
    }

    private static int[][] makeTwoDegreeSize(int[][] first, int[][] second) {
        int size = first.length > second.length ? first.length : second.length;

        for (int i = 0; i < first.length; i++) {
            if (size < first[i].length)
                size = first[i].length;
        }

        int[][] array;

        while (!isTwoDegree(size)) {
            ++size;
        }

        array = new int[size][size];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                array[i][j] = first[i][j];
            }
        }

        return array;
    }

}
