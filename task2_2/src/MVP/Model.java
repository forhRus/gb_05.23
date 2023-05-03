package MVP;

import base.Prize;
import db.Config;
import db.PrizeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model{
    private Config conf;
    private PrizeList prizeList;
    private PrizeList myPrizes;
    public Model(Config conf) {
        this.conf = conf;
        try{
            File filePrizeList = new File(conf.getPathPrizeList());
            prizeList = new PrizeList(loadList(filePrizeList));
            File fileMyPrizes = new File(conf.getMyPrizes());
            myPrizes = new PrizeList(loadList(fileMyPrizes));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public PrizeList getMyPrizes() {
        return myPrizes;
    }

    public PrizeList getPrizeList() {
        return prizeList;
    }

    public ArrayList<Prize> loadList(File file){
        ArrayList<Prize> l = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            while (line != null){
                l.add(parseLine(line));
                line = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    private Prize parseLine(String line){
        int idInt = Integer.valueOf(line.substring(0, line.indexOf(',')));
        String name = line.substring(line.indexOf(',')+1, line.lastIndexOf(','));
        int count = Integer.valueOf(line.substring(line.lastIndexOf(',')+1));
        Prize prize = new Prize(idInt, name, count);
        return prize;
    }
    public void addPrize(String name, int count){
        prizeList.add(name, count);
    }




//            while (line != null) {
//                list.add(parseLine(line));
//                line = bf.readLine();
//            }
//            fr.close();
//            bf.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

//    public void saveResult(List<String> list){
//        Config c = new Config();
//        try{
//            FileWriter fw = new FileWriter(c.getPathSave(), false);
//            for (String str: list) {
//                fw.write(str);
//            }
//            fw.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
