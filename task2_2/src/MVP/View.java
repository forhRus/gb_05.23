package MVP;

import java.util.List;

public class View {
    public void showMenu(String[] menu){
        for (int i = 0; i < menu.length ; i++) {
            System.out.printf("%d. %s\n", i+1, menu[i]);
        }
    }
    public void output(String msg){
        System.out.println(msg);
    }
}
