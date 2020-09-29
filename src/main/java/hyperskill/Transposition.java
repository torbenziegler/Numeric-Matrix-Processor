package hyperskill;

public class Transposition {
    public void transposeMatrix() {
        Calculation calc = new Calculation();

        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        int choice = Main.scanner.nextInt();

        double[][] matrix = calc.makeMatrix();

        System.out.println("The result is:");

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        double[][] result = new double[rowCount][colCount];

        switch (choice) {
            case 1:
                for (int i = 0; i < rowCount; i++) {
                    for (int j = 0; j < colCount; j++) {
                        result[i][j] = matrix[j][i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < rowCount; i++) {
                    for (int j = 0; j < colCount; j++) {
                        result[i][j] = matrix[rowCount - 1 - j][colCount - 1 - i];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < rowCount; i++) {
                    for (int j = 0; j < colCount; j++) {
                        result[i][j] = matrix[i][colCount - 1 - j];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < rowCount; i++) {
                    System.arraycopy(matrix[rowCount - i - 1], 0, result[i], 0, colCount);
                }
                break;
        }

        Calculation.displayMatrix(result);
    }

}
