package UI;

public class Menu {
    private String[] menu;
    private int exit;

    public Menu(String[] menu) {
        this.menu = menu;
        this.exit = menu.length;
    }

    public String[] getMenu() {
        return menu;
    }

    public int getExit() {
        return exit;
    }
}
