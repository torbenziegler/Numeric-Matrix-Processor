package hyperskill;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        while (true) {
            Menu.chooseOption(Menu.options());
        }
    }


}
