package UI;

import MVP.*;

import java.util.Scanner;

import db.Config;

public class App {
    private static Scanner scanner;
    private static View view;
    private static Model model;
    private static Controler controler;
    private static Menu mainMenu, listMenu, takeMenu;

    public static void start() {
        Config config = new Config();
        scanner = new Scanner(System.in);
        view = new View(scanner);
        model = new Model(config);
        controler = new Controler(view, model);

        controler.menu();
        endProgramm();
    }

    private static void endProgramm() {
        scanner.close();
        view.println("Программа завершена");
    }
}
