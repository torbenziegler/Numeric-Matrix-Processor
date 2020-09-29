package hyperskill;

public class Menu {

    public static int options() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.println("Your choice: ");

        return Main.scanner.nextInt();
    }

    public static void chooseOption(int option) {
        Calculation calc = new Calculation();

        switch (option) {
            case 1:
                calc.matrixAddition();
                break;
            case 2:
                calc.multiplyByConstant();
                break;
            case 3:
                calc.matrixMultiplication();
                break;
            case 4:
                Transposition transposition = new Transposition();
                transposition.transposeMatrix();
                break;
            case 5:
                Determinant det = new Determinant();
                det.getDeterminant();
                break;
            case 6:
                Inverse inverse = new Inverse();
                inverse.getInverse();
                break;
            case 0:
                System.exit(1);
                break;
        }
    }
}
