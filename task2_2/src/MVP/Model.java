package MVP;

import base.Prize;
import db.Config;
import base.PrizeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private Config conf;
    private PrizeList prizeList;
    private PrizeList myPrizes;
    private ArrayList<Integer> arrayRandomId;

    public Model(Config conf) {
        this.conf = conf;
        try {
            File filePrizeList = new File(conf.getPathPrizeList());
            prizeList = new PrizeList(loadList(filePrizeList));
            File fileMyPrizes = new File(conf.getMyPrizes());
            myPrizes = new PrizeList(loadList(fileMyPrizes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PrizeList getMyPrizes() {
        return myPrizes;
    }

    public PrizeList getPrizeList() {
        return prizeList;
    }

    public ArrayList<Integer> getArrayRandomId() {
        return arrayRandomId;
    }

    public ArrayList<Prize> loadList(File file) {
        ArrayList<Prize> l = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            while (line != null && line.length() > 0) {
                l.add(parseLine(line));
                line = bf.readLine();
            }
            bf.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return l;
    }

    private Prize parseLine(String line) {
        int idInt = Integer.valueOf(line.substring(0, line.indexOf(',')));
        String name = line.substring(line.indexOf(',') + 1, line.lastIndexOf(','));
        int count = Integer.valueOf(line.substring(line.lastIndexOf(',') + 1));
        Prize prize = new Prize(idInt, name, count);
        return prize;
    }

    public void addPrize(String name, int count) {
        prizeList.add(name, count);
    }

    public void createRandomArray() {
        ArrayList<Prize> tempList = prizeList.getList();
        int length = 0;
        for (int i = 0; i < tempList.size(); i++) {
            length += tempList.get(i).getCount();
        }
        System.out.println("Количество призов: " + length);
        //  считаем количество призов и создаём массив такой длины
        this.arrayRandomId = new ArrayList<>(length);
        int l = 0;
        for (int i = 0; i < tempList.size(); i++) {
            int id = tempList.get(i).getId();
            int count = tempList.get(i).getCount();
            for (int j = 0; j < count; j++) {
                this.arrayRandomId.add(id);
                l++;
            }
        }
        shaffle(this.arrayRandomId);
    }

    // метод перемешивает массив
    private void shaffle(ArrayList<Integer> arr) {
        Random r = new Random();
        int length = arr.size();
        for (int i = 0; i < length; i++) {
            int temp = arr.get(i);
            int rInd = r.nextInt(0, length);
            arr.set(i, arr.get(rInd));
            arr.set(rInd, temp);
        }
    }

    public void printRandomAr() {
        for (int i = 0; i < arrayRandomId.size(); i++) {
            System.out.print(arrayRandomId.get(i) + " ");
        }
        System.out.println();
    }

    public int takePrize() {
        int result = this.arrayRandomId.get(0);
        this.arrayRandomId.remove(0);
        return result;
    }

    public void deletePrize(int id) {
        prizeList.delete(id);
    }

    public void save() {
        File filePrizeList = new File(conf.getPathPrizeList());
        savePrizelist(filePrizeList, this.prizeList.getList());
        File fileMyPrizes = new File(conf.getMyPrizes());
        savePrizelist(fileMyPrizes, this.myPrizes.getList());
    }

    public void savePrizelist() {
        File filePrizeList = new File(conf.getPathPrizeList());
        savePrizelist(filePrizeList, this.prizeList.getList());
    }

    private void savePrizelist(File file, List<Prize> prizeList) {
        try {
            FileWriter fw = new FileWriter(file, false);
            for (Prize p : prizeList) {
                String saveStr = prizeStringToSave(p);
                fw.write(saveStr);
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String prizeStringToSave(Prize p) {
        return String.format("%d,%s,%d\n", p.getId(), p.getName(), p.getCount());
    }

}
