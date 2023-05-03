package db;

import base.Prize;

import java.util.ArrayList;

public class PrizeList {
    ArrayList<Prize> prizeList;
    int id;

    public PrizeList(ArrayList<Prize> prizeList) {
        this.prizeList = prizeList;
        setId();
    }

    public ArrayList<Prize> getList() {
        return prizeList;
    }

    public int getId() {
        return this.id;
    }

    public void add(String name, int count) {
        this.prizeList.add(new Prize(++this.id, name, count));
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

    private void setId(){
        int maxId = this.prizeList.get(0).getId();
        for (int i = 1; i < this.prizeList.size(); i++) {
            if (maxId < this.prizeList.get(i).getId()){
                maxId = this.prizeList.get(i).getId();
            }
        }
        this.id = maxId;
    }
}
