package base;

public class Toy {
    private int id;
    private String name;
    private int count;

    public Toy(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
    public void changeCount(int n){
        count += n;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
