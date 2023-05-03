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
        int input = 0;
        while (true) {
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                break;
            }
            scan.nextLine();
        }
        return input;
    }

    public int choiceInput(int length){
        while (true){
            int choice = inputInt();
            if (0 < choice && choice <= length) {
                return choice;
            }
        }
    }

    public void showMenu(String[] menu) {
        int point = 0;
        for (String p : menu) {
            System.out.printf("\t%d. %s\n", ++point, p);
        }
    }


}

