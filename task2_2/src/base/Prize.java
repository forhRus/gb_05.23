package base;

public class Prize {
    private int id;
    private String name;
    private int count;

    public Prize(int id, String name, int count) {
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

    @Override
    public String toString() {
        String result = String.format("id: %d, name: %s, count: %d",
                this.id, this.name, this.count);
        return result;
    }
}
