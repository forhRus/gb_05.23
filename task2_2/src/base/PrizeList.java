package base;

import base.Prize;

import java.util.ArrayList;

public class PrizeList {
    private ArrayList<Prize> prizeList;
    private int idCount;
    private int size;

    public PrizeList(ArrayList<Prize> prizeList) {
        this.prizeList = prizeList;
        this.size = prizeList.size();
        setId();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Prize> getList() {
        return prizeList;
    }

    public Prize getPrize(int id) {
        Prize p = new Prize(0, "", 0);
        for (int i = 0; i < this.size; i++) {
            p = this.prizeList.get(i);
            if (id == p.getId()) {
                break;
            }
        }
        return p;
    }

    public void add(int id, String name, int count) {
        size++;
        this.prizeList.add(new Prize(id, name, count));
    }

    public void add(String name, int count) {
        this.add(++this.idCount, name, count);
    }

    public void delete(int id) {
        for (int i = 0; i < this.prizeList.size(); i++) {
            if (id == this.prizeList.get(i).getId()) {
                this.prizeList.remove(i);
                break;
            }
        }
    }

    public boolean hasPrize(int id) {
        for (int i = 0; i < this.prizeList.size(); i++) {
            if (id == this.prizeList.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    public void setCount(int id, int count) {
        for (int i = 0; i < this.prizeList.size(); i++) {
            if (id == this.prizeList.get(i).getId()) {
                this.prizeList.get(i).setCount(count);
            }
        }
    }

    private void setId() {
        if (this.size > 0) {
            int maxId = this.prizeList.get(0).getId();
            for (int i = 1; i < this.prizeList.size(); i++) {
                if (maxId < this.prizeList.get(i).getId()) {
                    maxId = this.prizeList.get(i).getId();
                }
            }
            this.idCount = maxId;
        } else {
            this.idCount = 0;
        }

    }
}
