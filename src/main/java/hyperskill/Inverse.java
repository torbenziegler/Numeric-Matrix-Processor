package hyperskill;

public class Inverse {

    // Dimension of matrix
    static int dim;


    static void getCofactor(double[][] A, double[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = A[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static double determinant(double[][] A, int n) {
        double result = 0;

        if (n == 1) {
            return A[0][0];
        }

        double[][] temp = new double[dim][dim];

        int sign = 1;

        for (int f = 0; f < n; f++) {
            getCofactor(A, temp, 0, f, n);
            result += sign * A[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return result;
    }

    static void adjoint(double[][] A, double[][] adj) {
        if (dim == 1) {
            adj[0][0] = 1;
            return;
        }

        int sign;
        double[][] temp = new double[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                getCofactor(A, temp, i, j, dim);
                sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj[j][i] = (sign) * (determinant(temp, dim - 1));
            }
        }
    }

    static boolean inverse(double[][] A, double[][] inverse) {
        double det = determinant(A, dim);
        if (det == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return false;
        }

        double[][] adj = new double[dim][dim];
        adjoint(A, adj);

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                inverse[i][j] = adj[i][j] / det;
                if (inverse[i][j] == -0) {
                    inverse[i][j] = 0;
                }
            }
        }

        return true;
    }


    public void getInverse() {
        Calculation calc = new Calculation();
        double[][] matrix = calc.makeMatrix();

        dim = matrix.length;

        double[][] result = new double[matrix.length][matrix[0].length];

        if (inverse(matrix, result)) {
            Calculation.displayMatrix(result);
        }

    }


}
