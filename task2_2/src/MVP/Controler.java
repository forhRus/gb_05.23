package MVP;

import UI.Menu;
import db.Config;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Controler {
    View v;
    Model m;
    Menu mainMenu = new Menu(new String[]{
            "Начать розыгрыш",
            "Список призов",
            "Мои призы",
            "Выход"});
    Menu listMenu = new Menu(new String[]{
            "Показать список призов",
            "Добавить приз",
            "Удалить приз",
            "Изменить количество",
            "Назад"});
    Menu takeMenu = new Menu(new String[]{
            "Получить приз",
            "Закончить розыгрыш"});

    public Controler(View v, Model m) {
        this.v = v;
        this.m = m;
    }

    public void menu() {
        GG:
        while (true) {
            v.println("Главное меню");
            v.showMenu(mainMenu.getMenu());
            int choice = v.choiceInput(mainMenu.getExit());
            if (choice == mainMenu.getExit()) {
                break;
            }
            switch (choice) {
                case 4: // выход
                    break GG;
                case 1: // Начать розыгрыш
                    System.out.println("Начать розыгрыш");
                    break;
                case 2: // В меню "список призов"
                    listMenu();
                    break;
                case 3: // вывести список моих призов
                    System.out.println("вывести список моих призов");
                    v.showList(m.getMyPrizes());
                    break;
            }
        }
    }

    private void takeMenu() {
        GG:
        while (true) {
            v.showMenu(takeMenu.getMenu());
            int choice = v.inputInt();
            switch (choice) {
                case 2: // Сохранение списков и возврат в главное меню
                    break GG;
                case 1: // Получить случайный приз из списка
            }
        }
    }

    private void listMenu() {
        v.println("Выбирете действие:");
        Boolean flagSave = false;
        GG:
        while (true) {
            v.showMenu(listMenu.getMenu());
            int choice = v.choiceInput(listMenu.getExit());
            switch (choice) {
                case 5: // Вернуться в главное меню
                    break GG;
                case 1: // Показать список призов
                    v.showList(m.getPrizeList());
                    break;
                case 2: // Добавить приз
                case 3: // Удалить приз
                case 4: // изменить количество
            }
        }
    }


}
