package MVP;

import UI.Menu;
import base.Prize;


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
            int exit = mainMenu.getExit();
            int choice = v.choiceInput(exit);
            if (choice == exit) {
                break;
            }
            switch (choice) {
                case 1: // Начать розыгрыш
                    System.out.println("Для наглядности.");
                    m.createRandomArray();

                    if (m.getArrayRandomId().size() > 0) {
                        System.out.print("Очерёность выдачи призов: ");
                        m.printRandomAr();
                        System.out.println();
                        takeMenu();
                    } else {
                        v.println("Список призов пуст.");
                    }
                    break;
                case 2: // В меню "список призов"
                    listMenu();
                    break;
                case 3: // вывести список моих призов
                    v.println("Ваши призы:");
                    v.showList(m.getMyPrizes().getList());
                    break;
            }
        }
    }

    private void takeMenu() {
        Boolean flagSave = false;
        while (true) {
            v.showMenu(takeMenu.getMenu());
            int exit = takeMenu.getExit();
            int choice = v.choiceInput(exit);
            if (choice == exit) { // завершить розыгрыш
                if (flagSave) {
                    m.save();
                }
                break;
            }
            if (choice == 1) { //  получить приз
                int id = m.takePrize();
                flagSave = true;
                Prize prize = m.getPrizeList().getPrize(id);
                v.println(String.format("Вы выиграли: %s", prize.getName()));
                prize.changeCount(-1);
                if (prize.getCount() == 0) {
                    m.deletePrize(id);
                }
                if (m.getMyPrizes().hasPrize(id)) {
                    m.getMyPrizes().getPrize(id).changeCount(1);
                } else {
                    m.getMyPrizes().add(prize.getId(), prize.getName(), 1);
                }
                if (m.getArrayRandomId().size() == 0) {
                    v.println("Призы закончились");
                    m.save();
                    break;
                }
            }
            System.out.println();

        }
    }

    private void listMenu() {
        Boolean flagSave = false;
        GG:
        while (true) {
            v.println("Выбирите действие");
            v.showMenu(listMenu.getMenu());
            int choice = v.choiceInput(listMenu.getExit());
            switch (choice) {
                case 5: // Вернуться в главное меню
                    if (flagSave){
                        m.savePrizelist();
                    }
                    break GG;
                case 1: // Показать список призов
                    v.println("Список призов, участвующие в розыгрыше:");
                    v.showList(m.getPrizeList().getList());
                    break;
                case 2: // Добавить приз
                    flagSave = addPrize();
                    break;
                case 3: // Удалить приз
                    flagSave = deletePrize();
                    break;
                case 4: // изменить количество призов
                    flagSave = setCountPrize();
                    break;
            }
            v.println();
        }
    }

    private boolean addPrize() {
        String name;
        int count = 0;
        Boolean fSave = false;
        while (true) {
            v.print("Введите наименование приза: ");
            name = v.inputStr(16);
            if (name.equals("exit")) {
                break;
            } else if (name.length() > 0) {
                fSave = true;
                break;
            } else {
                System.out.println("Вы не ввели наименование. Для выхода введите 'exit'");
            }
        }
        while (fSave) {
            v.print("Введите количество призов: ");
            count = v.inputInt();
            if (count < 0) {
                fSave = false;
                break;
            } else if (count > 0) {
                fSave = true;
                break;
            } else {
                System.out.println("Вы не ввели количество. Для выхода введите '-1'");
            }
        }
        if (fSave) {
            m.addPrize(name, count);
        }
        return fSave;
    }

    private boolean deletePrize() {
        boolean fSave = false;
        v.print("Введите id приза, который хотите удалить: ");
        int id = v.inputInt();
        if (m.getPrizeList().hasPrize(id)) {
            m.deletePrize(id);
            fSave = true;
        } else {
            v.println("Приз с таким id не найден");
        }
        return fSave;
    }

    private boolean setCountPrize() {
        Boolean fSave = false;
        v.print("Введите id приза, количество которого хотите изменить: ");
        int id = v.inputInt();
        if (m.getPrizeList().hasPrize(id)) {
            v.print("Введите новое количество призов: ");
            int count = v.inputInt();
            if (count <= 0) {
                m.getPrizeList().setCount(id, 0);
            } else {
                m.getPrizeList().setCount(id, count);
            }
            fSave = true;
        } else {
            v.println("Приз с таким id не найден");
        }
        return fSave;
    }

}
