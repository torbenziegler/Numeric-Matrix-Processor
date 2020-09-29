package hyperskill;

public class Calculation {


    public static void displayMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
    }

    double[][] makeMatrix() {
        System.out.println("Enter size of matrix: ");
        int rowCount = Main.scanner.nextInt();
        int colCount = Main.scanner.nextInt();

        System.out.println("Enter matrix: ");

        double[][] matrix = new double[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                matrix[i][j] = Main.scanner.nextDouble();
            }
        }

        return matrix;
    }


    public void matrixAddition() {

        System.out.println("Create matrix A:");
        // Create matrix A
        double[][] matrixA = makeMatrix();
        int rowCountA = matrixA.length;
        int colCountA = matrixA[0].length;

        System.out.println("Create matrix B:");
        // Create matrix B
        double[][] matrixB = makeMatrix();
        int rowCountB = matrixB.length;
        int colCountB = matrixB[0].length;


        // Calculate result
        double[][] result = new double[rowCountA][colCountA];

        if (!(rowCountA == rowCountB && colCountA == colCountB)) {
            System.out.println("ERROR");
        } else {
            for (int i = 0; i < rowCountA; i++) {
                for (int j = 0; j < colCountA; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public void multiplyByConstant() {
        double[][] matrix = makeMatrix();
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        System.out.println("Enter constant: ");
        int constant = Main.scanner.nextInt();

        System.out.println("The result is:");
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i][j] = matrix[i][j] * constant;
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void matrixMultiplication() {

        double[][] matrixA = makeMatrix();
        int rowCountA = matrixA.length;
        int colCountA = matrixA[0].length;

        double[][] matrixB = makeMatrix();
        int rowCountB = matrixB.length;
        int colCountB = matrixB[0].length;


        if (colCountA != rowCountB) {
            System.out.println("The operation cannot be performed.");
        } else {
            double[][] result = new double[matrixA.length][matrixB[0].length];

            for (int row = 0; row < result.length; row++) {
                for (int col = 0; col < result[row].length; col++) {
                    result[row][col] = multiplyMatricesCell(matrixA, matrixB, row, col);
                }
            }

            for (int i = 0; i < rowCountA; i++) {
                for (int j = 0; j < colCountB; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }


}

