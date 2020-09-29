package hyperskill;

public class Determinant {

    static double getDeterminant(double[][] matrix) {
        double sum = 0;
        byte row = (byte) matrix.length;
        byte col = (byte) matrix[0].length;
        if (matrix[0].length == 1) return matrix[0][0];
        else {
            for (int i = 0; i < col; i++) {
                double[][] minor = new double[row - 1][col - 1];
                for (int k = 0, m = 1; m < row; k++, m++)
                    for (int l = 0, n = 0; n < col; l++, n++) {
                        if (n == i) {
                            l--;
                            continue;
                        }
                        minor[k][l] = matrix[m][n];
                    }
                sum += Math.pow(-1, i) * matrix[0][i] * getDeterminant(minor);
            }
        }
        return sum;
    }

    public void getDeterminant() {
        Calculation calc = new Calculation();

        double[][] matrix = calc.makeMatrix();

        System.out.println("The result is: ");
        System.out.println(getDeterminant(matrix));

    }
}
