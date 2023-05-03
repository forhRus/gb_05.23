package MVP;

import java.util.Scanner;

public class View {
    Scanner scan;

    public View(Scanner scan) {
        this.scan = scan;
    }

    public void print(Object msg) {
        System.out.print(msg.toString());
    }

    public void println(Object msg) {
        print(String.format("%s\n", msg));
    }

    public void println() {
        System.out.println();
    }

    public int inputInt() {
        int input;
        while (true) {
            scan.nextLine();
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                scan.nextLine();
                break;
            }
        }
        return input;
    }


    public void showMenu(String[] menu) {
        int point = 0;
        for (String p : menu) {
            System.out.printf("%d. %s\n", ++point, p);
        }
    }


}

