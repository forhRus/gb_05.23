package MVP;

import UI.Menu;


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
                    v.println("Ваши призы:");
                    v.showList(m.getMyPrizes().getList());
                    break;
            }
        }
    }

    private void takeMenu() {
        Boolean flagSave = false;
        GG:
        while (true) {
            v.showMenu(takeMenu.getMenu());
            int choice = v.inputInt();
            switch (choice) {
                case 2: // Сохранение списков и возврат в главное меню
                    if(flagSave){

                    }
                    break GG;
                case 1: // Получить случайный приз из списка
//                    flagSave = true;
                    break;
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
                    v.println("Список призов, участвующие в розыгрыше:");
                    v.showList(m.getPrizeList().getList());
                    break;
                case 2: // Добавить приз
                    addPrize();
                    break;
                case 3: // Удалить приз
                    v.print("Введите id приза, который хотите удалить: ");
                    int id = v.inputInt();
                    if (m.getPrizeList().hasPrize(id)){
                        m.getPrizeList().delete(id);
                    } else {
                        v.println("Приз с таким id не найден");
                    }
                    break;
                case 4: // изменить количество призов
                    
            }
        }
    }
    private void addPrize(){
        String name;
        int count = 0;
        Boolean f = false;
        while (true) {
            v.print("Введите наименование приза: ");
            name = v.inputStr(16);
            if (name.equals("exit")) {
                break;
            } else if (name.length() > 0){
                f = true;
                break;
            } else {
                System.out.println("Вы не ввели наименование. Для выхода введите 'exit'");
            }
        }
        while (f){
            v.print("Введите количество призов: ");
            count = v.inputInt();
            if (count < 0) {
                f = false;
                break;
            } else if (count > 0){
                f = true;
                break;
            } else {
                System.out.println("Вы не ввели количество. Для выхода введите '-1'");
            }
        }
        if(f){
            m.addPrize(name, count);
        }
        v.println();
    }

}
