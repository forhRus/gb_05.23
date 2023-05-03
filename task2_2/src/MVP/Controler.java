package MVP;

import base.Menu;

import java.util.ArrayList;



public class Controler {
    private Menu mainMenu = new Menu(new String[]{
            "Начать розыгрыш призов",
            "Список призов",
            "Мои призы",
            "Выход"});
    private Menu listPrizes = new Menu(new String[]{
            "Добавить приз",
            "Удалить приз",
            "Изменить количество",
            "Назад"});

    public void start() {
        View v = new View();
        v.output("Главное меню");
        v.showMenu(mainMenu.getMenu());
    }

}
