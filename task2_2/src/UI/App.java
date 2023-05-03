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
        mainMenu = new Menu(new String[]{
                "Начать розыгрыш",
                "Список призов",
                "Мои призы",
                "Выход"
        });
        listMenu = new Menu(new String[]{
                "Показать список призов",
                "Добавить приз",
                "Удалить приз",
                "Изменить количество",
                "Назад"
        });
        takeMenu = new Menu(new String[]{
                "Получить приз",
                "Закончить розыгруш"
        });

        mainMenu();
        endProgramm();
    }

    private static void mainMenu() {
        GG: while (true){
            view.println("Главное меню");
            view.showMenu(mainMenu.getMenu());
            int choice = view.choiceInput(mainMenu.getExit());
            if (choice == mainMenu.getExit()){
                break;
            }
            switch (choice){
                case 4: // выход
                    break GG;
                case 1: // Начать розыгрыш
                    System.out.println("Начать розыгрыш");
                    break;
                case 2: // В меню "список призов"
                    System.out.println("Список призов");
                    break;
                case 3: // вывести список моих призов
                    System.out.println("вывести список моих призов");
                    break;
            }
        }
    }
    private static void takeMenu() {
        GG: while (true){
            view.showMenu(takeMenu.getMenu());
            int choice = view.inputInt();
            switch (choice){
                case 4: // возврат в главное меню
                    break GG;
                case 1: // Получить случайный приз из списка
                case 2: // Сохранение списков и возврат в главное меню
                case 3: // вывести список моих призов
            }
        }
    }
    private static void listMenu() {
        Boolean flagSave = false;
        GG: while (true){
            view.showMenu(listMenu.getMenu());
            int choice = view.inputInt();
            switch (choice){
                case 5: // В меню "список призов"
                    break GG;
                case 1: // Показать список призов
                case 2: // Добавить приз
                case 3: // Удалить приз
                case 4: // изменить количество

            }
        }
    }

    private static void endProgramm() {
        scanner.close();
        view.println("Программа завершена");
    }
}
